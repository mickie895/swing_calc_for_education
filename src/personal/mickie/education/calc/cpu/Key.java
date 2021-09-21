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

	public int GetValue() {
		// TODO 自動生成されたメソッド・スタブ
		return value;
	}
}
