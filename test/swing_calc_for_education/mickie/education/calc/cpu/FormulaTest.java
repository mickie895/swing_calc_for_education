package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.Key;
import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;

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
		try {
			formula = formula.AddKey(Key.createFromString("1"));
		} catch (KeyOperateFailedException e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.GetResult(), 1);

		// 追加で5を押したら15になる
		try {
			formula = formula.AddKey(Key.createFromString("5"));
		} catch (KeyOperateFailedException e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.GetResult(), 15);

		// 更に0を10回押したら150,000,000になる(9桁制限)
		for (int i = 0; i < 10; i++) {
			try {
				formula = formula.AddKey(Key.createFromString("0"));
			} catch (KeyOperateFailedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		assertEquals(formula.GetResult(), 15 * (int)(Math.pow(10, 7)));
	}
	
	@Test
	public void PlusKeyTest() {
		try {
			formula = formula.AddKey(Key.createFromString("+"));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.GetResult(), 0);
	}

	@Test
	public void PlusKeyMultiInputTest() {
		try {
			formula = formula.AddKey(Key.createFromString("1"));
			formula = formula.AddKey(Key.createFromString("0"));
			formula = formula.AddKey(Key.createFromString("+"));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.GetResult(), 10);
	}
}
