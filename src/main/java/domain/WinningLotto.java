package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
	private final Lotto lotto;
	private final int bonusNo;

	public WinningLotto(Lotto lotto, int bonusNo) {
		if (lotto.isContain(bonusNo)) {
			throw new IllegalArgumentException("보너스 번호를 중복되게 입력 X");
		}
		this.lotto = lotto;
		this.bonusNo = bonusNo;
	}

	public Rank match(Lotto userLotto) {
		int count = userLotto.getCount(lotto);
		boolean isBonus = userLotto.isContain(bonusNo);
		return Rank.valueOf(count, isBonus);
	}
}
