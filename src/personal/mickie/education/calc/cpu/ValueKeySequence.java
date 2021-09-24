package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

public class ValueKeySequence {
	private List<ValueKey> sequence = new ArrayList<ValueKey>();

	private static final int MAX_DIGIT = 9;

	public ValueKeySequence() {
	}

	public void AddKey(Key nextKey) {
		if (nextKey instanceof ValueKey)
			sequence.add((ValueKey)nextKey);
	}

	public int GetValue() {
		return CompileKeyValue().GetValue();
	}

	private ValueKey CompileKeyValue() {
		ValueKey result = ValueKey.InitiallizeKey();

		for (ValueKey key : sequence) {
			result = result.AddValueKey(key);
		}

		return result;
	}

	public boolean CanAdd(Key nextKey) {
		if (!nextKey.IsValues()) {
			return false;
		}
		
		return (CompileKeyValue().GetLength() + nextKey.GetLength()) <= MAX_DIGIT;
	}
}
