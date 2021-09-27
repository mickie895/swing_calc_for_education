package personal.mickie.education.calc.cpu;

public class SignalKey extends Key {

	private String signal;
	
	private SignalKey(String signal) {
		this.signal = signal;
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
