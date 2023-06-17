package study;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StringCalculator {

    private enum Operator {
        ADD("+", (a, b) -> a + b),
        SUB("-", (a, b) -> a - b);

        private final String sign;

        private final BiFunction<Integer, Integer, Integer> function;

        Operator(final String sign, final BiFunction<Integer, Integer, Integer> function) {
            this.sign = sign;
            this.function = function;
        }

        private static Operator of(final String sign) {
            return Arrays.stream(values())
                .filter(op -> op.matchSign(sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such operator exists: " + sign));
        }

        private boolean matchSign(final String sign) {
            return this.sign.equals(sign);
        }

        public int calculate(final int operand1, final int operand2) {
            return this.function.apply(operand1, operand2);
        }
    }

    public int calculate(final String expression) {
        List<String> expressions = getExpressions(expression);
        int operand1 = Integer.parseInt(expressions.get(0));
        int operand2 = Integer.parseInt(expressions.get(2));
        return Operator.of(expressions.get(1))
            .calculate(operand1, operand2);
    }

    private static List<String> getExpressions(final String expression) {
        return Arrays
            .stream(expression.split("\\s+"))
            .collect(Collectors.toList());
    }
}
