package logic;

import domain.LottoGame;
import domain.WinningLotto;

public class Player {
    private final int buyCount;

    public Player() {
        buyCount = InputView.getBuyCount();
    }

    public void play() {
        LottoGame game = new LottoGame(buyCount);
        OutputView.printLottoList(game);
        WinningLotto winningLotto = InputView.getWinningLotto();
    }
}
