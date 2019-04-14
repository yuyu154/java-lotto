package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
        checkWinningLotto();
    }

    private void checkWinningLotto() {
        if (lotto.isContain(bonusNo)) {
            throw new IllegalArgumentException("bonusNum을 중복되지 않게 입력하세요");
        }

    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = userLotto.getCountOfMatch(lotto);
        boolean isBonus = userLotto.isContain(bonusNo);
        return Rank.valueOf(countOfMatch, isBonus);
    }
}
