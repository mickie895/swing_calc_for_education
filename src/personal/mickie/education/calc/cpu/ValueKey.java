package personal.mickie.education.calc.cpu;



public class ValueKey extends Key {

	public static ValueKey createNewValueKey(String keyString) {
		int keyValue = Integer.valueOf(keyString);
		ValueKey result = new ValueKey(keyValue, keyString.length());
		return result;
	}

	public static ValueKey getInitiallizeValueKey() {
		return new ValueKey(0, 0);
	}
	
	private int value = 0;
	private int keyLength = 0;

	private ValueKey(int initialValue, int keyStringLength) {
		value = initialValue;
		keyLength = keyStringLength;
	}
	
	private ValueKey(ValueKey source, ValueKey append) {
		value = source.value;
		for (int digits = 0; digits < append.keyLength; digits++)
			value *= 10;
		value += append.value;
		
		if (source.value != 0) 
			keyLength = source.keyLength;
		
		keyLength += append.keyLength;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public int getLength() {
		return keyLength;
	}

	public ValueKey addValueKey(ValueKey key) {
		return new ValueKey(this, key);
	}

	@Override
	public boolean isValues() {
		return true;
	}

}
