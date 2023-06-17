package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() - 현재 크기를 확인할 수 있다.")
    void size() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("provideItemForContains")
    @DisplayName("contains() - 1,2,3이 존재하는지 확인할 수 있다.")
    void contains(final int item, final boolean expected) {
        assertThat(numbers.contains(item)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideItemForContains() {
        return Stream.of(
            Arguments.of(1, true),
            Arguments.of(2, true),
            Arguments.of(3, true),
            Arguments.of(4, false),
            Arguments.of(5, false)
        );
    }
}
