package study;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StringCalculator {

    private enum Operator {
        ADD("+", (a, b) -> a + b);

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
    }

    public int calculate(final String expression) {
        List<Integer> numbers = getNumbers(expression);
        Integer operand1 = numbers.get(0);
        Integer operand2 = numbers.get(1);
        return operand1 + operand2;
    }

    private static List<Integer> getNumbers(final String expression) {
        return Arrays
            .stream(expression.split("\\W+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
