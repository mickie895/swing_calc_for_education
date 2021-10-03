package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.Key;

public class ClearItemTest {

	private Formula formula;
	
	@Before
	public void setUp() {
		formula = new Formula();
	}

	@Test
	public void CKeyTest() {
		try {
			// Cキー：全部まとめて消すタイプ
			formula = formula.addKey(Key.createFromString("10"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("10"));
			formula = formula.addKey(Key.createFromString("C"));
			formula = formula.addKey(Key.createFromString("5"));
			formula = formula.addKey(Key.createFromString("="));
			assertEquals(5, formula.getResult());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void CEKeyTest() {
		try {
			// CEキー：今入力中のデータだけ消すタイプ
			formula = formula.addKey(Key.createFromString("10"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("10"));
			formula = formula.addKey(Key.createFromString("CE"));
			formula = formula.addKey(Key.createFromString("5"));
			formula = formula.addKey(Key.createFromString("="));
			assertEquals(15, formula.getResult());
		} catch (Exception e) {
			fail();
		}
	}

}
