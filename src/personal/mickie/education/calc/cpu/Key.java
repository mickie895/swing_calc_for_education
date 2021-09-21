package personal.mickie.education.calc.cpu;

public class Key {

	public static Key GetFromString(String keyString) {
		int keyValue = Integer.valueOf(keyString);
		Key result = new Key(keyValue);
		return result;
	}
	
	private int value = 0;

	private Key(int initialValue) {
		value = initialValue;
	}
	
	private Key(Key source, Key append) {
		value = source.value * 10 + append.value;
	}

	public int GetValue() {
		// TODO 自動生成されたメソッド・スタブ
		return value;
	}

	public Key AddValueKey(Key key) {
		return new Key(this, key);
	}
}
