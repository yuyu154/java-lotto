package logic;

import domain.Lotto;
import domain.LottoNumber;
import domain.WinningLotto;
import util.InputUtil;
import util.LottoMaker;

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
        return makeWinningLotto(getUserLotto());
    }

    private static WinningLotto makeWinningLotto(Lotto lotto) {
        try {
            return new WinningLotto(lotto, getBonusNum());
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return makeWinningLotto(lotto);
        }
    }

    private static Lotto getUserLotto() {
        try {
            OutputView.print("지난 주 당첨 번호 입력");
            return LottoMaker.makeUserLotto(InputUtil.getUserIntList());
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getUserLotto();
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
