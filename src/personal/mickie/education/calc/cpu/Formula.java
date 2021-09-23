package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;

public class Formula {

	public Formula() {
		inputtedKey = new ValueKeySequence();
	}

	private ValueKeySequence inputtedKey;
	
	public Formula AddKey(Key nextKey) throws KeyOperateFailedException {
		if (!inputtedKey.CanAdd(nextKey)) {
			throw KeyOperateFailedException.NotEnoughDigitException();
		}
		
		inputtedKey.AddKey(nextKey);
		return this;
	}

	public int GetResult() {
		return inputtedKey.GetValue();
	}

}
