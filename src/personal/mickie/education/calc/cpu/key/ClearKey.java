package personal.mickie.education.calc.cpu.key;

public class ClearKey extends Key {

	public static ClearKey createFromString(String keyString) {
		return new ClearKey(keyString);
	}
	
	private String keyName;
	
	private ClearKey(String keyString) {
		keyName = keyString;
	}
	
	@Override
	public String getKeyString() {
		return keyName;
	}

}
