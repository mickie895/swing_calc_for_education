package personal.mickie.education.calc.cpu.signal;

import java.util.Map;
import java.util.function.BiFunction;

import personal.mickie.education.calc.cpu.ValueKeySequence;
import personal.mickie.education.calc.cpu.exception.DividedByZeroException;
import personal.mickie.education.calc.cpu.exception.FormulaException;
import personal.mickie.education.calc.cpu.key.IAddableValueKey;
import personal.mickie.education.calc.cpu.key.ValueKey;

public class SignalItemSet {

	public static class Factory{
		
		private static SignalItemSet CreateInstance(BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> work, BiFunction<ValueKeySequence, ValueKeySequence, FormulaException> exception) {
			return new SignalItemSet(work, exception);
		}

		// 計算用
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> plusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() + last.getValue());};
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> minusWork = (first, last) -> {return ValueKey.fromResult(first.getValue() - last.getValue());};
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> multiWork = (first, last) -> {return ValueKey.fromResult(first.getValue() * last.getValue());};
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> divWork = (first, last) -> {return ValueKey.fromResult(first.getValue() / last.getValue());};
		private static BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> emptyWork = (first, last) -> {return ValueKey.fromResult(first.getValue());};

		// 計算前チェック方法
		private static BiFunction<ValueKeySequence, ValueKeySequence, FormulaException> divCheck = (first, last) -> {
			if (last.getValue() == 0) {
				return new DividedByZeroException();
			}
			return null;
		};
		private static BiFunction<ValueKeySequence, ValueKeySequence, FormulaException> emptyCheck = (first, last) -> {return null;};
		
		// 計算の種類
		private static final Map<String, SignalItemSet> cachedSet = 
				Map.of(
						"+", CreateInstance(plusWork, emptyCheck),
						"-", CreateInstance(minusWork, emptyCheck),
						"*", CreateInstance(multiWork, emptyCheck),
						"/", CreateInstance(divWork, divCheck)
						);
		// デフォルト用
		private static final SignalItemSet defaultSet = CreateInstance(emptyWork, emptyCheck);
		
		public static SignalItemSet getSignalWorksFromMap(String signal) {
			return cachedSet.getOrDefault(signal, defaultSet);
		}
	}
	
	private SignalItemSet(BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> workFunction,
			BiFunction<ValueKeySequence, ValueKeySequence, FormulaException> checkExceptionFunction) {
		this.workFunction = workFunction;
		this.checkExceptionFunction = checkExceptionFunction;
	}

	private BiFunction<ValueKeySequence, ValueKeySequence, ValueKey> workFunction;
	private BiFunction<ValueKeySequence, ValueKeySequence, FormulaException> checkExceptionFunction;
	
	public ValueKey caluculate( ValueKeySequence firstTerm, ValueKeySequence lastTerm ) throws FormulaException{
		FormulaException possibleException = checkExceptionFunction.apply(firstTerm, lastTerm);
		if (possibleException != null) {
			throw possibleException;
		}
		return workFunction.apply(firstTerm, lastTerm);
	}
	
}
