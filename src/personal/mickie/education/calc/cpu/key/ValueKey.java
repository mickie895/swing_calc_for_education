package personal.mickie.education.calc.cpu.key;



public class ValueKey extends Key implements IAddableValueKey {
	public static ValueKey getInitiallizeValueKey() {
		return fromResult(0);
	}

	public static ValueKey fromResult(String keyString) {
		long keyValue = Long.valueOf(keyString);
		return new ValueKey(keyValue, keyString.length(), (keyValue < 0));
	}
	
	public static ValueKey fromResult(long rawValue) {
		int resultKeyLength = 0;
		long digitCheckValue = rawValue;
		boolean isMinus = false;
		if (rawValue < 0) {
			rawValue *= -1;
			isMinus = true;
		}
		
		while(digitCheckValue > 0) {
			resultKeyLength++;
			digitCheckValue /= 10;
		}
		
		return new ValueKey(rawValue, resultKeyLength, isMinus);
	}
	
	public static ValueKey fromKey(ValueKey copyFrom, boolean changeSignal) {
		ValueKey result = new ValueKey(copyFrom.value, copyFrom.keyLength, copyFrom.isMinus ^ changeSignal);
		
		return result;
	}
	
	private long value = 0;
	private int keyLength = 0;
	private boolean isMinus = false;

	private ValueKey(long initialValue, int keyStringLength, boolean isMinus) {
		value = initialValue;
		keyLength = keyStringLength;
		this.isMinus = isMinus;
	}
	
	private ValueKey(ValueKey source, ValueKey append) {
		value = source.value;
		for (int digits = 0; digits < append.keyLength; digits++)
			value *= 10;
		value += append.value;
		
		if (source.value != 0) 
			keyLength = source.keyLength;
		
		keyLength += append.keyLength;
		
		isMinus = source.isMinus ^ append.isMinus;
	}

	public long getValue() {
		if (isMinus)
			return -value;
		else
			return value;
	}
	
	@Override
	public String getKeyString() {
		return Long.toString(getValue());
	}
	
	@Override
	public int getLength() {
		return keyLength;
	}

	@Override
	public ValueKey addAfter(ValueKey beforeKey) {
		return new ValueKey(beforeKey, this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ValueKey))
			return false;
		ValueKey other = (ValueKey)obj;
		
		return value == other.value && keyLength == other.keyLength;
	}

}
