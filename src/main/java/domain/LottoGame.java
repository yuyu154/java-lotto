package domain;

import logic.OutputView;
import util.LottoNumberMaker;

import java.util.List;

public class LottoGame {
    private final int buyCount;
    private final List<Lotto> lottoList;

    public LottoGame(int buyCount) {
        this.buyCount = buyCount;
        lottoList = LottoNumberMaker.getLottoList(buyCount);
    }

    public void printResult() {
        OutputView.print(buyCount + "개를 구매했습니다");
        printLottoList();
    }

    private void printLottoList() {
        lottoList.forEach(lotto -> System.out.println(lotto));
    }
}
