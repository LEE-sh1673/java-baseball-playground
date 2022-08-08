package me.lee_sh1673;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	private static final String EXPRESSIONS = "2 + 3 * 4 / 2";
	StringCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new StringCalculator(EXPRESSIONS);
	}

	@DisplayName("계산기 초기화 검증 테스트")
	@Test
	void shouldInitializeCorrectly() {
		// when
		int[] operands = calculator.getOperands();
		String[] operators = calculator.getOperators();

		// then
		assertThat(operands).containsExactly(2, 3, 4, 2);
		assertThat(operators).containsExactly("+", "*", "/");
	}

	@DisplayName("계산기 연산 테스트")
	@Test
	void shouldComputeCorrectly() {
		// when
		int computedResult = calculator.compute();
		assertThat(computedResult).isEqualTo(10);
	}

	@DisplayName("수식 경계값 오류 테스트")
	@Test
	void shouldAssert_WhenOperatorsMoreThanOperands() {
		assertThatThrownBy(() -> calculator.compute())
			.as("Calculator 의 수식에서 연산자가 피연산자의 수보다 클 수 없음!")
			.isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

	@AfterEach
	void tearDown() {
		calculator = null;
	}
}