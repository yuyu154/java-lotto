package util;

import domain.LottoNumber;
import logic.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputUtil {

    private final static String COMMA = ",";
    private final static Scanner SCANNER = new Scanner(System.in);

    public static int getInt() {
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요");
            return getInt();
        }
    }

    public static List<Integer> getUserIntList() {
        try {
            return splitWithComma().stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            OutputView.print("숫자를 입력하세요");
            return getUserIntList();
        }
    }

    private static List<String> splitWithComma() {
        try {
            return Arrays.asList(getString().split(COMMA));
        } catch (Exception e) {
            OutputView.print("빈칸 X");
            return splitWithComma();
        }
    }

    private static String getString() {
        return SCANNER.nextLine();
    }
}
