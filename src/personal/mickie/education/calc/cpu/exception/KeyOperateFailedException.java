package personal.mickie.education.calc.cpu.exception;

public class KeyOperateFailedException extends FormulaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6097856381532220265L;

	private static final String MESSAGE_NOT_ENOUGH_DIGIT = "桁数が9桁を超えます。";
	
	public static KeyOperateFailedException NotEnoughDigitException() {
		return new KeyOperateFailedException(MESSAGE_NOT_ENOUGH_DIGIT);
	}
	
	public KeyOperateFailedException(String message) {
		super(message);
	}
}
