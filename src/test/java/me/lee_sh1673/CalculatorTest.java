package me.lee_sh1673;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("me.lee_sh1673.Calculator 단위 테스트")
class CalculatorTest {

	@Test
	@DisplayName("덧셈 테스트")
	public void shouldAddCorrectly()  {
		assertEquals(7, Calculator.ADD.compute(3, 4));
	}

	@Test
	@DisplayName("뺄셈 테스트")
	public void shouldSubtractCorrectly()  {
		assertEquals(1, Calculator.SUB.compute(5, 4));
	}

	@Test
	@DisplayName("곱셈 테스트")
	public void shouldMultiplyCorrectly()  {
		assertEquals(6, Calculator.MUL.compute(2, 3));
	}

	@Test
	@DisplayName("나누기 테스트")
	public void shouldDivideCorrectly()  {
		assertEquals(2, Calculator.DIV.compute(8, 4));
	}
}