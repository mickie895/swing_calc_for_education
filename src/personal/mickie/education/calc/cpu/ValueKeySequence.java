package personal.mickie.education.calc.cpu;

import java.util.ArrayList;
import java.util.List;

public class ValueKeySequence {
	private List<Key> sequence = new ArrayList<Key>();
	
	public ValueKeySequence() {
	}
	
	public void AddKey(Key nextKey) {
		sequence.add(nextKey);
	}
	
	public int GetValue() {
		
		Key result = Key.GetFromString("0");
		
		for (Key key : sequence) {
			result = result.AddValueKey(key);
		}
		
		return result.GetValue();
	}
}
