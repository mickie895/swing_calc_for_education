package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.Key;
import personal.mickie.education.calc.cpu.exception.KeyOperateFailedException;

public class ValueKeyTest {

	private Formula formula;

	@Before
	public void InitializeFormula() {
		formula = new Formula();
	}

	@Test
	public void SimpleFormulatest() {
		// 何も入れなければ0を返す
		assertEquals(formula.getResult(), 0);

		// 1のキーを式に送信したら1を返す
		try {
			formula = formula.addKey(Key.createFromString("1"));
		} catch (Exception e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.getResult(), 1);

		// 追加で5を押したら15になる
		try {
			formula = formula.addKey(Key.createFromString("5"));
		} catch (Exception e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.getResult(), 15);

		// 更に0を7回押したら150,000,000になる(9桁制限ぴったり)
		for (int i = 0; i < 7; i++) {
			try {
				formula = formula.addKey(Key.createFromString("0"));
			} catch (Exception e) {
				// 9桁制限に達するまでは例外は出ない
				fail();
			}
		}
		assertEquals(formula.getResult(), 15 * (int)(Math.pow(10, 7)));

		// 更に0押したら9桁制限の例外が出る
		try {
			formula = formula.addKey(Key.createFromString("0"));
			// 例外が出るからここで止まる
			fail();
		} catch (KeyOperateFailedException e) {
			// 期待されている例外が出ている
		} catch (Exception e) {
			// 想定外の例外は失敗扱い
			fail();
		}

		assertEquals(formula.getResult(), 15 * (int) (Math.pow(10, 7)));
	
	}
	

}
