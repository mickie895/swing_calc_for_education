package personal.mickie.education.calc.cpu.signal;

import java.util.function.BiFunction;

import personal.mickie.education.calc.cpu.ValueKey;

public class SignalWorkFactory {

	public static BiFunction<ValueKey, ValueKey, ValueKey> GetSignalWork(String signal){
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
			throw new IllegalArgumentException("Unexpected value: " + signal);
		}
	}
	
	private static BiFunction<ValueKey, ValueKey, ValueKey> plusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() + last.getValue());};
	
	private static BiFunction<ValueKey, ValueKey, ValueKey> minusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() - last.getValue());};
	
	private static BiFunction<ValueKey, ValueKey, ValueKey> multiWork = (first, last) -> {return ValueKey.fromResult(first.getValue() * last.getValue());};
	
	private static BiFunction<ValueKey, ValueKey, ValueKey> divWork = (first, last) -> {return ValueKey.fromResult(first.getValue() / last.getValue());};
	
}
