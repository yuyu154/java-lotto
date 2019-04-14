package logic;

import domain.Lotto;
import domain.WinningLotto;

import java.util.List;

public class Player {
    private final int buyCount;
    private final List<Lotto> userLottoList;

    public Player() {
        buyCount = InputView.getBuyCount();
        userLottoList = InputView.getRandomLottoList(buyCount);
    }

    public void play() {
        OutputView.printBuyResult(buyCount, userLottoList);
        WinningLotto winningLotto = InputView.getWinningLotto();
    }
}
