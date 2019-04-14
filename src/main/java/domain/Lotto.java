package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        checkIfValidLotto();
    }

    // 추가 기능 구현
    private void checkIfValidLotto() {
        Set checkSet = new HashSet(numbers);
        if (checkSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복되지 않게 로또 6자리 입력하세요");
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
