package personal.mickie.education.calc.cpu;

import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;

public class Formula {

	public Formula() {
		inputtedKey = new ValueKeySequence();
	}

	// 第一項
	private ValueKeySequence inputtedKey;
	
	// 記号
	private SignalKey signals;
	
	// 第二項(後で)
	
	public Formula AddKey(Key key) throws KeyOperateFailedException {
		return AddValueKey(key);
	}

	private Formula AddValueKey(Key key) throws KeyOperateFailedException {
		if (!inputtedKey.CanAdd(key)) {
			throw KeyOperateFailedException.NotEnoughDigitException();
		}
		
		inputtedKey.AddKey(key);
		return this;
	}
	
	private Formula AddSignalKey(Key key) {
		return this;
	}

	public int GetResult() {
		return inputtedKey.GetValue();
	}

}
