package personal.mickie.education.calc.cpu.exception;

public class DividedByZeroException extends FormulaException implements IStopCalculationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1609033866873941413L;

	public DividedByZeroException() {
		super("数値をゼロで割ろうとしています。");
	}
}
