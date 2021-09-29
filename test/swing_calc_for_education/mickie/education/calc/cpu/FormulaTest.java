package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import personal.mickie.education.calc.cpu.Formula;
import personal.mickie.education.calc.cpu.Key;
import personal.mickie.education.calc.cpu.ValueKey;
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
		assertEquals(formula.getResult(), 0);

		// 1のキーを式に送信したら1を返す
		try {
			formula = formula.addKey(Key.createFromString("1"));
		} catch (KeyOperateFailedException e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.getResult(), 1);

		// 追加で5を押したら15になる
		try {
			formula = formula.addKey(Key.createFromString("5"));
		} catch (KeyOperateFailedException e) {
			// 例外は普通は出ない
			fail();
		}
		assertEquals(formula.getResult(), 15);

		// 更に0を10回押したら150,000,000になる(9桁制限)
		for (int i = 0; i < 10; i++) {
			try {
				formula = formula.addKey(Key.createFromString("0"));
			} catch (KeyOperateFailedException e) {
				System.out.println(e.getMessage());
			}
		}
		
		assertEquals(formula.getResult(), 15 * (int)(Math.pow(10, 7)));
	}
	
	@Test
	public void PlusKeyTest() {
		try {
			formula = formula.addKey(Key.createFromString("+"));
		}catch (Exception e){
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
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 10);
		
		try {
			formula = formula.addKey(Key.createFromString("2"));
			formula = formula.addKey(Key.createFromString("3"));
			formula = formula.addKey(Key.createFromString("4"));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 234);
		
		try {
			formula = formula.addKey(Key.createFromString("="));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 244);
		
		try {
			formula = formula.addKey(Key.createFromString("-"));
			formula = formula.addKey(Key.createFromString("144"));
			formula = formula.addKey(Key.createFromString("="));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 100);
		
		try {
			formula = formula.addKey(Key.createFromString("/"));
			formula = formula.addKey(Key.createFromString("50"));
			formula = formula.addKey(Key.createFromString("="));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 2);
		
		try {
			formula = formula.addKey(Key.createFromString("*"));
			formula = formula.addKey(Key.createFromString("7"));
			formula = formula.addKey(Key.createFromString("="));
		}catch (Exception e){
			System.out.println(e.getMessage());
			fail();
		}
		
		assertEquals(formula.getResult(), 14);
	}
	
	@Test
	public void KeyCreateTest() {
		ValueKey resultKey = ValueKey.fromResult(123);
		ValueKey stringKey = ValueKey.createNewValueKey("123");
		
		assertEquals(resultKey, stringKey);
	}
	
}
