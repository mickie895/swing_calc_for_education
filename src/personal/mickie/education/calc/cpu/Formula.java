package personal.mickie.education.calc.cpu;

public class Formula {

	public Formula() {
		inputtedKey = new ValueKeySequence();
	}

	private ValueKeySequence inputtedKey;
	
	public Formula AddKey(Key nextKey) {
		inputtedKey.AddKey(nextKey);
		return this;
	}

	public int GetResult() {
		return inputtedKey.GetValue();
	}

}
