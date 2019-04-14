package util;

import java.util.Scanner;

public class InputUtil {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static int getMoney() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return getMoney();
        }
    }

    private static String getString() {
        return SCANNER.nextLine();
    }
}
