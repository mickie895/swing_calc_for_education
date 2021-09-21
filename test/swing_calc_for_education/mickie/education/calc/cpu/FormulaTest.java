package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.Key;

public class FormulaTest {

	private Formula formula;

	@Before
	public void InitializeFormula() {
		formula = new Formula();
	}

	@Test
	public void SimpleFormulatest() {
		// 何も入れなければ0を返す
		assertEquals(formula.GetResult(), 0);
		
		// 1のキーを式に送信したら1を返す
		formula = formula.AddKey(Key.GetFromString("1"));
		assertEquals(formula.GetResult(), 1);
		
		// 追加で5を押したら15になる
		formula = formula.AddKey(Key.GetFromString("5"));
		assertEquals(formula.GetResult(), 15);
	}

}
