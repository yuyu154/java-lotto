package logic;

import domain.Lotto;
import domain.LottoNumber;
import domain.Money;
import domain.WinningLotto;
import util.InputUtil;
import util.LottoMaker;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static Money getMoney() {
        try {
            System.out.println("구입금액을 입력하세요");
            return new Money(InputUtil.getInt());
        } catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            return getMoney();
        }
    }

    public static List<Lotto> getRandomLottoList(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < money.getGameCount(); i++) {
            lottoList.add(LottoMaker.makeRandomLotto());
        }
        return lottoList;
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
