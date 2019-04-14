package logic;

import domain.LottoGame;

public class OutputView {

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printLottoList(LottoGame game) {
        game.printResult();
    }
}

