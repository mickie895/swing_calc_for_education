package personal.mickie.education.calc.cpu;

public class Formula {

	public Formula() {
		inputtedKey = Key.GetFromString("0");
	}

	private Key inputtedKey;
	
	public Formula AddKey(Key getFromString) {
		inputtedKey = getFromString;
		return this;
	}

	public int GetResult() {
		return inputtedKey.GetValue();
	}

}
