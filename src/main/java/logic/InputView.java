package logic;

import util.InputUtil;

public class InputView {
    private static final int MIN_MONEY = 1000;

    public static int getBuyCount() {
        System.out.println("구입금액을 입력하세요");
        int money = InputUtil.getMoney();
        if (money < MIN_MONEY) {
            //다시
        }
        return (money / MIN_MONEY);
    }
}
