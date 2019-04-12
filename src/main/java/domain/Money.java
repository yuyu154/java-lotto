/*
 * Money.java
 */
package domain;

public class Money {
	private static final int MONEY_PER_LOTTO = 1000;

	private final int money;

	public Money(int money) {
		if (money < MONEY_PER_LOTTO) {
			throw new IllegalArgumentException
					("1000원 이상 구입하세요");
		}
		this.money = money;
	}

	public int getLottoCount() {
		return (money / MONEY_PER_LOTTO);
	}
}
