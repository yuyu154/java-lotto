package domain;

import logic.OutputView;

import java.util.*;

public class LottoResult {
    private Map<Rank, Integer> resultMap;

    public LottoResult(List<Lotto> userLottoList, WinningLotto winningLotto) {
        initMap();
        calcMap(userLottoList, winningLotto);
    }

    private void calcMap(List<Lotto> userLottoList, WinningLotto winningLotto) {
        for (Lotto lotto : userLottoList) {
            putMap(winningLotto.match(lotto));
        }
    }

    private void putMap(Rank rank) {
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    private void initMap() {
        this.resultMap = new HashMap<Rank, Integer>();
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
    }

    public void printRankInfo(Rank rank) {
        if (rank != Rank.MISS) {
            System.out.print(rank);
            OutputView.print(" - " + resultMap.get(rank) + "개");
        }
    }

    public double getProfitRate() {
        return (getWinningSum() / getBuySum());
    }

    private int getBuySum() {
        int sum = 0;
        for (Rank rank : resultMap.keySet()) {
            sum += resultMap.get(rank);
        }
        return Money.getTotalBuy(sum);
    }

    private int getWinningSum() {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            sum += rank.getPrize(resultMap.get(rank));
        }
        return sum;
    }
}
