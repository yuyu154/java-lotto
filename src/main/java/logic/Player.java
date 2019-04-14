package logic;

public class Player {
    private final int buyCount;

    public Player() {
        buyCount = InputView.getBuyCount();
    }

    public void play() {
        OutputView.printLottoList(buyCount);
    }
}
