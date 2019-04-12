/*
 * InputUtil.java
 */

package util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputUtil {
	private static final String BLANK_REGEX = "(^\\s*$)";
	private static final String NUMBER_REGEX = "(^[0-9]+$)";
	private static final String COMMA = ",";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int getInt() {
		try {
			return Integer.parseInt(SCANNER.nextLine().trim());
		} catch (IllegalArgumentException e) {
			System.out.println("숫자 입력하세요");
			return getInt();
		}
	}

	public static List<Integer> getIntegerList() {
		try {
			List<String> strList = Arrays.asList(SCANNER.nextLine().split(COMMA));
			return makeIntegerList(strList);
		} catch (IllegalArgumentException e) {
			System.out.println("다시 입력하세요");
			return getIntegerList();
		}
	}

	private static List<Integer> makeIntegerList(List<String> strList) {
		return strList.stream()
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	/*
	public static List<Integer> getIntegerList() {
		List<String> strList;
		do {
			strList = Arrays.asList(getString().split(COMMA));
		} while (!isNumberList(strList));
		return makeIntegerList(strList);
	}

	private static List<Integer> makeIntegerList(List<String> strList) {
		return strList.stream()
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
*/

	/*
	private static boolean isNumberList(List<String> strList) {
		return strList.stream().allMatch(InputUtil::isNumber);
	}

	private static boolean isNumber(String input) {
		if (input.trim().matches(NUMBER_REGEX)) {
			return true;
		}
		System.out.println("숫자를 입력하세요");
		return false;
	}
*/
	/*
	private static String getString() {
		String input;
		do {
			input = SCANNER.nextLine();
		} while (isBlank(input));
		return input;
	}

	private static boolean isBlank(String input) {
		if (input.matches(BLANK_REGEX)) {
			System.out.println("빈칸을 입력하셨습니다.");
			return true;
		}
		return false;
	}
	*/
}
