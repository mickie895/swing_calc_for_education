package personal.mickie.education.calc.cpu;

public class LockedSequence extends ValueKeySequence {
	public LockedSequence(ValueKey lockTarget) {
		super(lockTarget);
	}
	
	@Override
	public ValueKeySequence addKey(Key nextKey) {
		return new ValueKeySequence((ValueKey)nextKey);
	}

	@Override
	public boolean canAdd(Key nextKey) {
		if (!nextKey.isValues()) {
			return false;
		}

		return nextKey.getLength() <= ValueKeySequence.MAX_DIGIT;
	}
}
