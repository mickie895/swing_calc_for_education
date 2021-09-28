package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.signal.SignalWork;

public class SignalKey extends Key {

	private String signal;
	private SignalWork work;
	
	private SignalKey(String signal) {
		this.signal = signal;
		this.work = SignalWork.Factory.CreateSignalWork(signal);
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

	public ValueKeySequence compireTerms(ValueKeySequence firstTerm, ValueKeySequence lastTerm) {
		return new ValueKeySequence(work.caluculate(firstTerm, lastTerm));
	}

}
