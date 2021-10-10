package personal.mickie.education.calc.cpu.key;

import personal.mickie.education.calc.cpu.LockedSequence;
import personal.mickie.education.calc.cpu.ValueKeySequence;
import personal.mickie.education.calc.cpu.exception.FormulaException;
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

	public static Key createNewSignalKey(String keyString) {
		return new SignalKey(keyString);
	}
	
	public static Key getInitiallizeSignalKey() {
		return new SignalKey("=");
	}

	public ValueKeySequence compireTerms(ValueKeySequence firstTerm, ValueKeySequence lastTerm) throws FormulaException {
		return new LockedSequence(workSet.caluculate(firstTerm, lastTerm));
	}

	@Override
	public String getKeyString() {
		return signal;
	}
}
