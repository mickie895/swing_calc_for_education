package personal.mickie.education.calc.cpu;



public class ValueKey extends Key {

	public static ValueKey createNewValueKey(String keyString) {
		int keyValue = Integer.valueOf(keyString);
		ValueKey result = new ValueKey(keyValue, keyString.length());
		return result;
	}

	public static ValueKey InitiallizeKey() {
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
		
		if (source.GetValue() != 0) 
			keyLength = source.keyLength;
		
		keyLength += append.keyLength;
	}

	public int GetValue() {
		return value;
	}
	
	@Override
	public int GetLength() {
		return keyLength;
	}

	public ValueKey AddValueKey(ValueKey key) {
		return new ValueKey(this, key);
	}

	@Override
	public boolean IsValues() {
		return true;
	}
}
