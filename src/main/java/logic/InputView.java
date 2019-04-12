/*
 * InputView.java
 */

package logic;

import domain.Lotto;
import domain.Money;
import domain.WinningLotto;
import util.DuplicateValidator;
import util.InputUtil;
import util.NumberValidator;
import util.SizeValidator;

import static domain.LottoConstant.*;

class InputView {
	private static final NumberValidator NUMBER_VALIDATOR = new NumberValidator(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
	private static final DuplicateValidator DUPLICATE_VALIDATOR = new DuplicateValidator();
	private static final SizeValidator SIZE_VALIDATOR = new SizeValidator(LOTTO_SIZE);

	/*
	public static int getLottoCount() {

		int money;
		System.out.println("구입금액을 입력해주세요.");
		do {
			money = InputUtil.getInt();
		} while (!isValidMoney(money));
		return (money / LOTTO_MIN_MONEY);

	}

	private static boolean isValidMoney(int money) {
		if (money >= LOTTO_MIN_MONEY) {
			return true;
		}
		System.out.println("1000원 이상의 금액을 입력해주세요.");
		return false;
	}
	*/

	public static int getLottoCount() {
		try {
			System.out.println("구입금액을 입력해주세요.");
			Money money = new Money(InputUtil.getInt());
			return money.getLottoCount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getLottoCount();
		}
	}

	public static WinningLotto getWinningLotto() {
		Lotto lotto = getWinningLottoNumbers();
		try {
			return new WinningLotto(lotto, getBonusNumber(lotto));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getWinningLotto();
		}
	}

	private static Lotto getWinningLottoNumbers() {
		try {
			System.out.println("지난 주 당첨번호를 입력해 주세요.");
			return new Lotto(InputUtil.getIntegerList());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getWinningLottoNumbers();
		}
	}

	private static int getBonusNumber(Lotto lotto) {
		try {
			System.out.println("보너스 볼을 입력해주세요");
			return InputUtil.getInt();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBonusNumber(lotto);
		}
	}
}
