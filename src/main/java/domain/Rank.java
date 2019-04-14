package domain;

import logic.OutputView;

import java.util.Arrays;

/**
 * 로또 등수를 의미하는 enum
 */
public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    private boolean matchMoney(int winningMoneymoney) {
        return this.winningMoney == winningMoneymoney;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(this.getCountOfMatch() + "개 일치 ");
        ret.append(getBonusString());
        ret.append("(" + this.getWinningMoney() + "원)");
        return ret.toString();
    }

    private String getBonusString() {
        StringBuilder ret = new StringBuilder();
        if (SECOND.matchMoney(this.winningMoney)) {
            ret.append(", 보너스 볼 일치");
        }
        return ret.toString();
    }

    public int getPrize(int count) {
        return (this.winningMoney * count);
    }
}

