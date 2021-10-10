package personal.mickie.education.calc.cpu.key;

public class ValueSignalKey extends Key implements IAddableValueKey {
	public static ValueSignalKey CreateNewSignalKey(String keyString) {
		return new ValueSignalKey(keyString);
	}
	
	private String keyLabel;
	
	private ValueSignalKey(String keyString) {
		keyLabel = keyString;
	}


	@Override
	public String getKeyString() {
		return keyLabel;
	}

	@Override
	public ValueKey addAfter(ValueKey beforeKey) {
		return ValueKey.fromKey(beforeKey, true);
	}
}
