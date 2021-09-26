package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

public class ValueKeySequence {
	private List<ValueKey> sequence = new ArrayList<ValueKey>();

	private static final int MAX_DIGIT = 9;

	public ValueKeySequence() {
	}

	public void addKey(Key nextKey) {
		if (nextKey instanceof ValueKey)
			sequence.add((ValueKey)nextKey);
	}

	public int getValue() {
		return compileKeyValue().GetValue();
	}
	
	public boolean hasValue() {
		return sequence.size() > 0;
	}

	private ValueKey compileKeyValue() {
		ValueKey result = ValueKey.InitiallizeKey();

		for (ValueKey key : sequence) {
			result = result.AddValueKey(key);
		}

		return result;
	}

	public boolean canAdd(Key nextKey) {
		if (!nextKey.isValues()) {
			return false;
		}
		
		return (compileKeyValue().GetLength() + nextKey.GetLength()) <= MAX_DIGIT;
	}
}
