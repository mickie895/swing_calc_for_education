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

	@Test
	public void SignalTest() {
		ValueKeySequence sequence = new ValueKeySequence();
		sequence = sequence.addKey(Key.createFromString("10"));
		sequence = sequence.addKey(Key.createFromString("+/-"));
		assertEquals(sequence.getValue(), -10);
		sequence = sequence.addKey(Key.createFromString("5"));
		assertEquals(sequence.getValue(), -105);
		sequence = sequence.addKey(Key.createFromString("+/-"));
		assertEquals(sequence.getValue(), 105);
	}

}
