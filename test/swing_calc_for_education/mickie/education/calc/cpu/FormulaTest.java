package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.exception.DividedByZeroException;
import personal.mickie.education.calc.cpu.key.Key;

public class FormulaTest {

	private Formula formula;

	@Before
	public void InitializeFormula() {
		formula = new Formula();
	}

	@Test
	public void PlusKeyTest() {
		try {
			formula = formula.addKey(Key.createFromString("+"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 0);
	}

	@Test
	public void PlusKeyMultiInputTest() {
		try {
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("0"));
			formula = formula.addKey(Key.createFromString("+"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 10);

		try {
			formula = formula.addKey(Key.createFromString("2"));
			formula = formula.addKey(Key.createFromString("3"));
			formula = formula.addKey(Key.createFromString("4"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 234);

		try {
			formula = formula.addKey(Key.createFromString("="));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 244);

		try {
			formula = formula.addKey(Key.createFromString("-"));
			formula = formula.addKey(Key.createFromString("144"));
			formula = formula.addKey(Key.createFromString("="));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 100);

		try {
			formula = formula.addKey(Key.createFromString("/"));
			formula = formula.addKey(Key.createFromString("50"));
			formula = formula.addKey(Key.createFromString("="));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 2);

		try {
			formula = formula.addKey(Key.createFromString("*"));
			formula = formula.addKey(Key.createFromString("7"));
			formula = formula.addKey(Key.createFromString("="));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 14);
	}

	@Test
	public void MultiSignalTest() {

		try {
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("="));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}

		assertEquals(formula.getResult(), 3);
	}

	@Test
	public void DivZeroTest() {
		try {
			formula = formula.addKey(Key.createFromString("123"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("/"));
			formula = formula.addKey(Key.createFromString("0"));
			formula = formula.addKey(Key.createFromString("="));
			// ??????????????????????????????
			fail();
		} catch (DividedByZeroException e) {
			// ????????????????????????
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// ????????????????????????
			fail();
		}
	}
	
	@Test
	public void LockedValueTest() {

		try {
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("1"));
			formula = formula.addKey(Key.createFromString("="));
			formula = formula.addKey(Key.createFromString("5"));
			// =????????????????????????????????????????????????????????????????????????????????????????????????
			assertEquals(formula.getResult(), 5);
			formula = formula.addKey(Key.createFromString("+"));
			formula = formula.addKey(Key.createFromString("5"));
			formula = formula.addKey(Key.createFromString("="));
			assertEquals(formula.getResult(), 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

}
