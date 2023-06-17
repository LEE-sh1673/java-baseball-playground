package feedback;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {
    ADD("+", Integer::sum),
    SUB("-", (a,b) -> a - b),
    MUL("*", (a,b) -> a * b),
    DIV("/", (a,b) -> a / b);

    private final String operator;

    private final BiFunction<Integer, Integer, Integer> function;

    Calculator(final String operator, final BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static int compute(final int op1, final int op2, final String operator) {
        return Calculator.of(operator).compute(op1, op2);
    }

    private int compute(final int op1, final int op2) {
        return this.function.apply(op1, op2);
    }

    private static Calculator of(final String operator) {
        return Arrays.stream(values())
            .filter(op -> op.matchOperator(operator))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("해당 연산자가 없습니다. : " + operator));
    }

    private boolean matchOperator(final String operator) {
        return this.operator.equals(operator);
    }
}
