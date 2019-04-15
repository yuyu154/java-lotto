package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.Money;
import domain.WinningLotto;

import java.util.List;

public class Player {
    private final Money money;
    private final List<Lotto> userLottoList;

    public Player() {
        money = InputView.getMoney();
        userLottoList = InputView.getRandomLottoList(money);
    }

    public void play() {
        OutputView.printBuyResult(money, userLottoList);
        WinningLotto winningLotto = InputView.getWinningLotto();
        LottoResult lottoResult = new LottoResult(userLottoList, winningLotto);
        OutputView.printStat(lottoResult);
        OutputView.printProfitRate(lottoResult);
    }
}
