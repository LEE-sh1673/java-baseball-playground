package me.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {

	ADD("+", Integer::sum),
	SUB("-", (a, b) -> a - b),
	MUL("*", (a, b) -> a * b),
	DIV("/", (a, b) -> a / b);

	private final String operator;

	private final BiFunction<Integer, Integer, Integer> biFunction;

	Calculator(final String operator, BiFunction<Integer, Integer, Integer> biFunction) {
		this.operator = operator;
		this.biFunction = biFunction;
	}

	public static int compute(final int op1, final int op2, final String operator) {
		Calculator cal = Arrays.stream(Calculator.values())
			.filter(calculator -> calculator.operator.equals(operator))
			.findFirst()
			.orElseThrow(RuntimeException::new);
		return cal.biFunction.apply(op1, op2);
	}
}
