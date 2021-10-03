package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Test;

import personal.mickie.education.calc.cpu.ValueKeySequence;
import personal.mickie.education.calc.cpu.key.Key;

public class ValueKeySequenceTest {

	@Test
	public void InstanceTest() {
		ValueKeySequence firstKey = new ValueKeySequence();
		ValueKeySequence secondKey = firstKey.addKey(Key.createFromString("1"));
		
		// 副作用を起こさないように毎回異なるインスタンスにする。
		assertNotEquals(firstKey, secondKey);
	}

}
