package me.lee_sh1673;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum Calculator {

	ADD("+", (op1, op2) -> op1 + op2),
	SUB("-", (op1, op2) -> op1 - op2),
	MUL("*", (op1, op2) -> op1 * op2),
	DIV("/", (op1, op2) -> op1 / op2);

	private final String operator;

	private final BiFunction<Integer, Integer, Integer> biFunction;

	Calculator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
		this.operator = operator;
		this.biFunction = biFunction;
	}

	private static Optional<Calculator> findCalculatorBy(final Predicate<Calculator> predicate) {
		return Arrays.stream(Calculator.values())
			.filter(predicate)
			.findAny();
	}

	public static int compute(final int op1,
		final int op2,
		final String operator) {

		return findCalculatorBy(op -> op.operator.equals(operator))
			.orElseThrow(RuntimeException::new)
			.compute(op1, op2);
	}

	public int compute(final int op1, final int op2) {
		return this.biFunction.apply(op1, op2);
	}
}
