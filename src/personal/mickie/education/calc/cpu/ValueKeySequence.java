package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

import personal.mickie.education.calc.cpu.key.IAddableValueKey;
import personal.mickie.education.calc.cpu.key.Key;
import personal.mickie.education.calc.cpu.key.ValueKey;

public class ValueKeySequence {
	protected List<IAddableValueKey> sequence = new ArrayList<IAddableValueKey>();

	protected static final int MAX_DIGIT = 9;

	public ValueKeySequence() {
	}

	public ValueKeySequence(ValueKey startValueKey) {
		sequence.add(startValueKey);
	}
	
	private ValueKeySequence copyInstance() {
		ValueKeySequence result = new ValueKeySequence();
		result.sequence = new ArrayList<IAddableValueKey>(sequence);
		
		return result;
	}

	public ValueKeySequence addKey(Key nextKey) {
		if (!(nextKey instanceof IAddableValueKey))
			return this;

		ValueKeySequence resultInstance = copyInstance();
		
		resultInstance.sequence.add((IAddableValueKey) nextKey);
		return resultInstance;
	}
	
	public ValueKeySequence removeLast() {
		ValueKeySequence result = new ValueKeySequence();
		
		// 最後のキーを打ち消すため、現時点で1個以下のキーだったら
		if (sequence.size() <= 1) {
			return result;
		}		
		
		// 副作用防止
		result.sequence = new ArrayList<IAddableValueKey>( sequence.subList(0, sequence.size() - 1));
		return result;
	}

	public long getValue() {
		return compileKeyValue().getValue();
	}

	public boolean hasValue() {
		return sequence.size() > 0;
	}

	public ValueKey compileKeyValue() {
		ValueKey result = ValueKey.getInitiallizeValueKey();

		for (IAddableValueKey key : sequence) {
			result = key.addAfter(result);
		}

		return result;
	}

	public boolean canAdd(Key nextKey) {
		if (!(nextKey instanceof IAddableValueKey)) {
			return false;
		}

		return (compileKeyValue().getLength() + nextKey.getLength()) <= MAX_DIGIT;
	}
}
