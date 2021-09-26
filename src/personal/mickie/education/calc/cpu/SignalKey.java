package personal.mickie.education.calc.cpu;

public class SignalKey extends Key {

	private SignalKey(String signal) {
		this.singal = signal;
	}
	
	String singal;
	
	@Override
	public boolean isValues() {
		return false;
	}

	public static Key createNewSignalKey(String keyString) {
		// TODO 自動生成されたメソッド・スタブ
		return new SignalKey(keyString);
	}

}
