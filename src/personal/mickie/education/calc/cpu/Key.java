package personal.mickie.education.calc.cpu;

public class Key {

	public static Key GetFromString(String keyString) {
		int keyValue = Integer.valueOf(keyString);
		Key result = new Key(keyValue, keyString.length());
		return result;
	}
	
	public static Key InitiallizeKey() {
		return new Key(0, 0);
	}
	
	private int value = 0;
	private int keyLength = 0;

	private Key(int initialValue, int keyStringLength) {
		value = initialValue;
		keyLength = keyStringLength;
	}
	
	private Key(Key source, Key append) {
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
	
	public int DigitLength() {
		return keyLength;
	}

	public Key AddValueKey(Key key) {
		return new Key(this, key);
	}
}
