package swing_calc_for_education.mickie.education.calc.cpu;

import static org.junit.Assert.*;

import org.junit.Test;

import personal.mickie.education.calc.cpu.Key;
import personal.mickie.education.calc.cpu.ValueKeySequence;

public class ValueKeySequenceTest {

	@Test
	public void InstanceTest() {
		ValueKeySequence firstKey = new ValueKeySequence();
		ValueKeySequence secondKey = firstKey.addKey(Key.createFromString("1"));
		
		assertNotEquals(firstKey, secondKey);
	}

}
