package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;
import personal.mickie.education.calc.cpu.key.ClearKey;
import personal.mickie.education.calc.cpu.key.Key;
import personal.mickie.education.calc.cpu.key.SignalKey;
import personal.mickie.education.calc.cpu.key.ValueKey;

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

	// 第一項
	private ValueKeySequence firstTerm;

	// 記号
	private SignalKey signals;

	// 第二項
	private ValueKeySequence lastTerm;

	public Formula addKey(Key key) throws Exception {
		if (key instanceof ValueKey)
			return addValueKey(key);

		if (key instanceof ClearKey)
			return clearFormula(key);

		return addSignalKey(key);
	}

	private Formula clearFormula(Key key) {
		if (!(key instanceof ClearKey)) {
			return this;
		}

		if (key.getKeyString().equals("C")) {
			return new Formula();
		}

		if (canAddToFirstTerm()) {
			return new Formula();
		}

		return new Formula(this.firstTerm, new ValueKeySequence(), this.signals);
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

	private Formula addSignalKey(Key key) throws Exception {
		if (lastTerm.hasValue()) {
			compileToFirstTerm();
		}

		if (key instanceof SignalKey)
			signals = (SignalKey) key;

		return this;
	}

	private void compileToFirstTerm() throws Exception {
		firstTerm = signals.compireTerms(firstTerm, lastTerm);
		lastTerm = new ValueKeySequence();
	}

	public long getResult() {
		if (lastTerm.hasValue())
			return lastTerm.getValue();

		return firstTerm.getValue();
	}

}
