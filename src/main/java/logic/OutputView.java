package logic;

public class OutputView {

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printLottoList(int buyCount) {
        print(buyCount + "개를 구매했습니다");
    }
}
