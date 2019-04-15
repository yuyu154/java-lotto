package domain;

public class Money {
    private final static int MIN_MONEY = 1000;

    private final int money;

    public Money(int money) {
        this.money = money;
        if (this.money < MIN_MONEY) {
            throw new IllegalArgumentException("1000원 이상 입력");
        }
    }

    public int getGameCount() {
        return (this.money / MIN_MONEY);
    }

    public int gameTotalBuy() {
        return (getGameCount() * MIN_MONEY);
    }

    public static int getTotalBuy(int count) {
        return (count * MIN_MONEY);
    }
}
