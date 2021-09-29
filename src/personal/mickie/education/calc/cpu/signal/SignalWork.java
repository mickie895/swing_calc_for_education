package personal.mickie.education.calc.cpu.signal;

import java.util.function.BiFunction;

import personal.mickie.education.calc.cpu.ValueKey;
import personal.mickie.education.calc.cpu.ValueKeySequence;

public class SignalWork {

	public static class Factory{

		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> plusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() + last.getValue());};
		
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> minusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() - last.getValue());};
		
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> multiWork = (first, last) -> {return ValueKey.fromResult(first.getValue() * last.getValue());};

		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> divWork = (first, last) -> {return ValueKey.fromResult(first.getValue() / last.getValue());};

		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> emptyWork = (first, last) -> {return ValueKey.fromResult(first.getValue());};
		
		public static SignalWork CreateSignalWork(String signal) {
			return new SignalWork(GetWork(signal));
		}
		
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> GetWork(String signal){
			switch (signal) {
			case "+": 
				return plusWork;
			case "-": 
				return minusWork;
			case "*": 
				return multiWork;
			case "/": 
				return divWork;
			default:
				return emptyWork;
			}
		}
	}
	
	private SignalWork(BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> attachWork) {
		work = attachWork;
	}
	
	private BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> work;
	
	public ValueKey caluculate(ValueKeySequence first, ValueKeySequence last) {
		return work.apply(first, last);
	}
	
}
