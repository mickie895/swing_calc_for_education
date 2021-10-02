package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

public class ValueKeySequence {
	protected List<ValueKey> sequence = new ArrayList<ValueKey>();

	private static final int MAX_DIGIT = 9;

	public ValueKeySequence() {
	}

	public ValueKeySequence(ValueKey startValueKey) {
		sequence.add(startValueKey);
	}
	
	private ValueKeySequence copyInstance() {
		ValueKeySequence result = new ValueKeySequence();
		result.sequence = new ArrayList<ValueKey>(sequence);
		
		return result;
	}

	public ValueKeySequence addKey(Key nextKey) {
		if (!(nextKey instanceof ValueKey))
			return this;

		ValueKeySequence resultInstance = copyInstance();
		
		resultInstance.sequence.add((ValueKey) nextKey);
		return resultInstance;
	}

	public long getValue() {
		return compileKeyValue().getValue();
	}

	public boolean hasValue() {
		return sequence.size() > 0;
	}

	public ValueKey compileKeyValue() {
		ValueKey result = ValueKey.getInitiallizeValueKey();

		for (ValueKey key : sequence) {
			result = result.addValueKey(key);
		}

		return result;
	}

	public boolean canAdd(Key nextKey) {
		if (!nextKey.isValues()) {
			return false;
		}

		return (compileKeyValue().getLength() + nextKey.getLength()) <= MAX_DIGIT;
	}
}
