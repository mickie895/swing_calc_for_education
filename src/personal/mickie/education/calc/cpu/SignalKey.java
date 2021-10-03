package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.signal.SignalItemSet;

public class SignalKey extends Key {

	private String signal;
	private SignalItemSet workSet;
	
	private SignalKey(String signal) {
		this.signal = signal;
		this.workSet = SignalItemSet.Factory.getSignalWorksFromMap(signal);
	}
	
	public boolean hasNoOperate() {
		return signal.equals("=");
	}
	
	@Override
	public boolean isValues() {
		return false;
	}

	public static Key createNewSignalKey(String keyString) {
		return new SignalKey(keyString);
	}
	
	public static Key getInitiallizeSignalKey() {
		return new SignalKey("=");
	}

	public ValueKeySequence compireTerms(ValueKeySequence firstTerm, ValueKeySequence lastTerm) throws Exception {
		return new LockedSequence(workSet.caluculate(firstTerm, lastTerm));
	}

}
