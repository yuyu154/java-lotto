package util;

import domain.Lotto;
import logic.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    //Int 리스트를 Lotto로 변환하는 것을 담당한다.

    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public static Lotto makeUserLotto(List<Integer> intList) {
        return makeLotto(intList);
    }

    public static Lotto makeRandomLotto() {
        try {
            return makeLotto(getRandomIntList());
        } catch (Exception e) {
            return makeRandomLotto();
        }
    }

    private static Lotto makeLotto(List<Integer> intList) {
        return new Lotto(intList);
    }

    private static List<Integer> getRandomIntList() {
        List<Integer> randomIntList = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            randomIntList.add(RandomNumberMaker.getRandomNumber(MAX_NUMBER, MIN_NUMBER));
        }
        return randomIntList;
    }
}
