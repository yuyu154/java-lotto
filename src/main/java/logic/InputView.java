package logic;

import domain.Lotto;
import domain.LottoNumber;
import domain.WinningLotto;
import util.InputUtil;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final int MIN_MONEY = 1000;

    public static int getBuyCount() {
        System.out.println("구입금액을 입력하세요");
        int money = InputUtil.getInt();
        if (money < MIN_MONEY) {
            //다시
        }
        return (money / MIN_MONEY);
    }

    public static WinningLotto getWinningLotto() {
        Lotto winningLotto = makeWinningLotto();
        int bonusNum = getBonusNum();
        return new WinningLotto(winningLotto, bonusNum);
    }

    private static Lotto makeWinningLotto() {
        try {
            return new Lotto(getValidLottoNumberList());
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return makeWinningLotto();
        }
    }

    private static List<Integer> getValidLottoNumberList() {
        try {
            return InputUtil.getIntList().stream()
                    .map(LottoNumber::new)
                    .map(LottoNumber::intValue)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getValidLottoNumberList();
        }
    }

    private static int getBonusNum() {
        try {
            OutputView.print("보너스 번호를 입력해주세요");
            return new LottoNumber(InputUtil.getInt()).intValue();
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getBonusNum();
        }
    }
}
