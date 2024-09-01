package StringCalc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalcTest {
	private StringCalc hw;
	@BeforeEach
	public void setup() {
		hw = new StringCalc();
	}
	
	// null이나 empty string
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {""})
	void nullAndEmptyTest(String input) throws Throwable {
		assertEquals(0, hw.add(input));
	}
	
	// 숫자 1개면 그대로
	@ParameterizedTest
	@ValueSource(strings = {"3"})
	void oneNumTest(String input) throws Throwable {
		assertEquals(3, hw.add(input));
	}
	
	// 구분자를 쉼표나 콜론
	@ParameterizedTest
	@ValueSource(strings = {"1:2:3", "2,3,1", "2,3:1"})
	void formalDelimeterTest(String input) throws Throwable {
		assertEquals(6, hw.add(input));
	}
	
	// 커스텀 구분자
	@ParameterizedTest
	@ValueSource(strings = {"//.\n1.2.3"})
	void customDelimeterTest(String input) throws Throwable {
		assertEquals(6, hw.add(input));
	}
	
	// 음수가 있는 경우
	@ParameterizedTest
	@ValueSource(strings = {"-1,3,2"})
	void negNumTest(String input) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hw.add(input);
        });
	}
	
}
