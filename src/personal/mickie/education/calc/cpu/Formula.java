package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.exception.FormulaException;
import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;
import personal.mickie.education.calc.cpu.key.ClearKey;
import personal.mickie.education.calc.cpu.key.IAddableValueKey;
import personal.mickie.education.calc.cpu.key.Key;
import personal.mickie.education.calc.cpu.key.SignalKey;

public class Formula {

	public Formula() {
		firstTerm = new ValueKeySequence();
		lastTerm = new ValueKeySequence();
		signals = (SignalKey) SignalKey.getInitiallizeSignalKey();
	}

	private Formula(ValueKeySequence first, ValueKeySequence last, SignalKey signals) {
		firstTerm = first;
		lastTerm = last;
		this.signals = signals;
	}

	private Formula copyInstance() {
		return new Formula(firstTerm, lastTerm, signals);
	}
	
	// 第一項
	private ValueKeySequence firstTerm;

	// 記号
	private SignalKey signals;

	// 第二項
	private ValueKeySequence lastTerm;

	public Formula addKey(Key key) throws FormulaException {
		if (key instanceof IAddableValueKey)
			return addValueKey(key);

		if (key instanceof ClearKey)
			return clearFormula(key);

		return addSignalKey(key);
	}

	private Formula clearFormula(Key key) {
		if (!(key instanceof ClearKey)) {
			return this;
		}

		if (key.getKeyString().equals("←")) {
			return backSpaseFormula();
		}
		
		if (key.getKeyString().equals("C")) {
			return new Formula();
		}

		if (canAddToFirstTerm()) {
			return new Formula();
		}

		return new Formula(this.firstTerm, new ValueKeySequence(), this.signals);
	}
	
	private Formula backSpaseFormula() {
		Formula result = copyInstance();
		
		if (canAddToFirstTerm()) {
			result.firstTerm = firstTerm.removeLast();
			return result;
		}
		
		if (lastTerm.hasValue()) {
			result.lastTerm = lastTerm.removeLast();
			return result;
		}
		
		result.signals = (SignalKey) SignalKey.getInitiallizeSignalKey();
		return result;
	}

	private Formula addValueKey(Key key) throws KeyOperateFailedException {
		ValueKeySequence addTarget = firstTerm;

		if (!canAddToFirstTerm()) {
			addTarget = lastTerm;
		}

		if (!addTarget.canAdd(key)) {
			throw KeyOperateFailedException.NotEnoughDigitException();
		}

		if (canAddToFirstTerm()) {
			return new Formula(addTarget.addKey(key), lastTerm, signals);
		}

		return new Formula(firstTerm, addTarget.addKey(key), signals);
	}

	private boolean canAddToFirstTerm() {
		return (signals == null) || (signals.hasNoOperate());
	}

	private Formula addSignalKey(Key key) throws FormulaException {
		if (lastTerm.hasValue()) {
			compileToFirstTerm();
		}

		if (key instanceof SignalKey)
			signals = (SignalKey) key;

		return this;
	}

	private void compileToFirstTerm() throws FormulaException {
		firstTerm = signals.compireTerms(firstTerm, lastTerm);
		lastTerm = new ValueKeySequence();
	}

	public long getResult() {
		if (lastTerm.hasValue())
			return lastTerm.getValue();

		return firstTerm.getValue();
	}

}
