package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

public class ValueKeySequence {
	private List<Key> sequence = new ArrayList<Key>();

	private static final int MAX_DIGIT = 9;

	public ValueKeySequence() {
	}

	public void AddKey(Key nextKey) {
		sequence.add(nextKey);
	}

	public int GetValue() {
		return CompileKeyValue().GetValue();
	}

	private Key CompileKeyValue() {
		Key result = Key.InitiallizeKey();

		for (Key key : sequence) {
			result = result.AddValueKey(key);
		}

		return result;
	}

	public boolean CanAdd(Key nextKey) {
		return (CompileKeyValue().DigitLength() + nextKey.DigitLength()) <= MAX_DIGIT;
	}
}
