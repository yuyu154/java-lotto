package logic;

import domain.Lotto;

import java.util.List;

public class OutputView {

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printBuyResult(int buyCount, List<Lotto> userLottoList) {
        printResult(buyCount);
        printLottoList(userLottoList);
    }

    public static void printResult(int buyCount) {
        OutputView.print(buyCount + "개를 구매했습니다");
    }

    private static void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto));
    }
}

