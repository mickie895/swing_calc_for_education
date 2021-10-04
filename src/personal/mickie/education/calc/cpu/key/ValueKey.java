package personal.mickie.education.calc.cpu.key;



public class ValueKey extends Key {

	public static ValueKey createNewValueKey(String keyString) {
		int keyValue = Integer.valueOf(keyString);
		ValueKey result = new ValueKey(keyValue, keyString.length());
		return result;
	}

	public static ValueKey getInitiallizeValueKey() {
		return new ValueKey(0, 0);
	}
	
	public static ValueKey fromResult(long rawValue) {
		int resultKeyLength = 0;
		long digitCheckValue = rawValue;
		
		while(digitCheckValue > 0) {
			resultKeyLength++;
			digitCheckValue /= 10;
		}
		
		return new ValueKey(rawValue, resultKeyLength);
	}
	
	private long value = 0;
	private int keyLength = 0;

	private ValueKey(long initialValue, int keyStringLength) {
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

	public long getValue() {
		return value;
	}
	
	@Override
	public String getKeyString() {
		// TODO 自動生成されたメソッド・スタブ
		return Long.toString(value);
	}
	
	@Override
	public int getLength() {
		return keyLength;
	}

	public ValueKey addValueKey(ValueKey key) {
		return new ValueKey(this, key);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ValueKey))
			return false;
		ValueKey other = (ValueKey)obj;
		
		return value == other.value && keyLength == other.keyLength;
	}

}
