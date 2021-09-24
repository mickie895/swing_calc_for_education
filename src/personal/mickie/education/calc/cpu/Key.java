package personal.mickie.education.calc.cpu;

import java.util.regex.Pattern;

public abstract class Key {

	private static final Pattern ValueDigitPattern = Pattern.compile("\\d*");
	private static final String DotSymbol = ".";

	public static Key GetFromString(String keyString) {
		if (keyString.equals(DotSymbol)) {
			throw new UnsupportedOperationException("小数点は今の所未実装。");
		}
		
		if (ValueDigitPattern.matcher(keyString).matches()) {
			return ValueKey.GetFromString(keyString);
		}
		
		return null;
	}

	public static Key InitiallizeKey() {
		return ValueKey.InitiallizeKey();
	}
	
	public abstract boolean IsValues();

	public int GetLength() {
		return 0;
	}
	
	public Key() {
		super();
	}

}