package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.Money;
import domain.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printBuyResult(Money money, List<Lotto> userLottoList) {
        printResult(money);
        printLottoList(userLottoList);
    }

    public static void printResult(Money money) {
        OutputView.print(money.getGameCount() + "개를 구매했습니다");
    }

    private static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto));
    }

    public static void printProfitRate(LottoResult lottoResult) {
        System.out.printf("수익률은 %.3f 입니다", lottoResult.getProfitRate());
    }

    public static void printStat(LottoResult lottoResult) {
        OutputView.print("당첨 통계");
        OutputView.print("-------");
        reverseValues().forEach(rank -> lottoResult.printRankInfo(rank));
    }

    private static List<Rank> reverseValues() {
        List<Rank> rankList = Arrays.asList(Rank.values());
        Collections.reverse(rankList);
        return rankList;
    }
}

