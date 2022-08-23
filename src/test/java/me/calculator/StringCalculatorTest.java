package me.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	static final String STATEMENT = "2 + 3 * 4 / 2";

	@DisplayName("문자열 파싱 테스트")
	@Test
	void should_split_correctly() {
		String[] words = StatementSplitter.split(STATEMENT);
		assertThat(words.length).isEqualTo(7);
		assertThat(words).containsExactly("2", "+", "3", "*", "4", "/", "2");
	}

	@DisplayName("문자열 연산자/피연산자 구분 테스트")
	@Test
	void should_parse_correctly() {
		// give
		String[] words = StatementSplitter.split(STATEMENT);
		StatementParser statementParser = new StatementParser(words);

		// when
		int[] operands = statementParser.getOperands();
		String[] operators = statementParser.getOperators();

		// then
		assertThat(operands.length).isEqualTo(4);
		assertThat(operands).containsExactly(2, 3, 4, 2);

		assertThat(operators.length).isEqualTo(3);
		assertThat(operators).containsExactly("+", "*", "/");
	}

	@DisplayName("계산 기능 테스트")
	@Test
	void should_compute_statement_correctly() {
		// give
		String[] words = StatementSplitter.split(STATEMENT);
		StatementParser statementParser = new StatementParser(words);
		StatementCalculator calculator = new StatementCalculator(
			statementParser.getOperators(),
			statementParser.getOperands()
		);

		// when
		int result = calculator.compute();

		// then
		assertThat(result).isEqualTo(10);
	}

	@DisplayName("StringCalculator 기능 테스트")
	@Test
	void should_get_answer() {
		StringCalculator calculator = new StringCalculator(STATEMENT);
		int result = calculator.compute();
		assertThat(result).isEqualTo(10);
	}
}
