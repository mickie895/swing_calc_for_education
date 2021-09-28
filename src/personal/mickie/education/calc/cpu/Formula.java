package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;

public class Formula {

	public Formula() {
		firstTerm = new ValueKeySequence();
		lastTerm = new ValueKeySequence();
		signals = (SignalKey) SignalKey.getInitiallizeSignalKey();
	}

	// 第一項
	private ValueKeySequence firstTerm;
	
	// 記号
	private SignalKey signals;

	// 第二項
	private ValueKeySequence lastTerm;
	
	public Formula addKey(Key key) throws KeyOperateFailedException {
		if (key.isValues())
			return addValueKey(key);
		
		if (lastTerm.hasValue()) {
			compileToFirstTerm();
		}
		
		return addSignalKey(key);
	}

	private Formula addValueKey(Key key) throws KeyOperateFailedException {
		ValueKeySequence addTarget = firstTerm;
		
		if ((signals != null) && (!signals.hasNoOperate())) {
			addTarget = lastTerm;
		}
		
		if (!addTarget.canAdd(key)) {
			throw KeyOperateFailedException.NotEnoughDigitException();
		}
		
		addTarget.addKey(key);
		return this;
	}
	
	private Formula addSignalKey(Key key) {
		if (key instanceof SignalKey)
			signals = (SignalKey) key;
			
		return this;
	}
	
	private void compileToFirstTerm() {
		firstTerm = signals.compireTerms(firstTerm, lastTerm);
		lastTerm = new ValueKeySequence();
	}

	public int getResult() {
		if (lastTerm.hasValue())
			return lastTerm.getValue();
		
		return firstTerm.getValue();
	}

}
