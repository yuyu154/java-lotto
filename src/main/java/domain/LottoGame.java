package domain;

import logic.OutputView;
import util.LottoMaker;
import util.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int buyCount;
    private final List<Lotto> lottoList;

    public LottoGame(int buyCount) {
        this.buyCount = buyCount;
        this.lottoList = makeRandomLottoList();
    }

    public void printResult() {
        OutputView.print(buyCount + "개를 구매했습니다");
        printLottoList();
    }

    private List<Lotto> makeRandomLottoList() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(LottoMaker.makeRandomLotto());
        }
        return lottoList;
    }

    private void printLottoList() {
        lottoList.forEach(lotto -> System.out.println(lotto));
    }
}
