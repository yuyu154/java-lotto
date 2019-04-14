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

    public void printStat() {
        OutputView.print("당첨 통계");
        OutputView.print("-------");
        for (Rank rank : reverseValues()) {
            printRankInfo(rank);
        }
    }

    private static List<Rank> reverseValues() {
        List<Rank> rankList = Arrays.asList(Rank.values());
        Collections.reverse(rankList);
        return rankList;
    }

    private void printRankInfo(Rank rank) {
        if (Rank.MISS != rank) {
            System.out.print(rank);
            OutputView.print(" - " + resultMap.get(rank) + "개");
        }
    }
}
