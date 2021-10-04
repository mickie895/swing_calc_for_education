package personal.mickie.education.calc.cpu.key;

import java.util.regex.Pattern;

public abstract class Key {

	private static final Pattern ClearkeyPattern = Pattern.compile("CE?");
	private static final Pattern ValueDigitPattern = Pattern.compile("\\d*");
	private static final String DotSymbol = ".";
	
	public abstract String getKeyString();

	public static Key createFromString(String keyString) {
		if (keyString.equals(DotSymbol)) {
			throw new UnsupportedOperationException("小数点は今の所未実装。");
		}
		
		if (ClearkeyPattern.matcher(keyString).matches()) {
			return ClearKey.createFromString(keyString);
		}
		
		if (ValueDigitPattern.matcher(keyString).matches()) {
			return ValueKey.createNewValueKey(keyString);
		}
		
		return SignalKey.createNewSignalKey(keyString);
	}

	public static Key InitiallizeKey() {
		return ValueKey.InitiallizeKey();
	}

	public int getLength() {
		return 0;
	}

}