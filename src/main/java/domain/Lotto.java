package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this(new HashSet(numbers));
	}

	private Lotto(Set<LottoNumber> lotto) {
		if (lotto.size() != LottoConstant.LOTTO_SIZE) {
			throw new IllegalArgumentException("6자리의 다른 숫자를 입력하세요 (중복X)");
		}
		numbers = new ArrayList(lotto);
	}

	// 추가 기능 구현
	public String toString() {
		return numbers.toString();
	}

	public int getCount(Lotto compareLotto) {
		return (int) numbers.stream()
				.filter(number -> compareLotto.isContain(number))
				.count();
	}


	public boolean isContain(int number) {
		return numbers.contains(number);
	}
}
