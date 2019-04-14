package util;

import domain.Lotto;
import domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberMaker {
    private  static final  int MAX_NUMBER = 45;
    private  static final int MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    private static final Random RANDOM = new Random();

    public static Lotto getRandomLotto() {
        return new Lotto(makeRandomLotto());
    }

    private static List<Integer> makeRandomLotto() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lotto.add(getLottoNumber().intValue());
        }
        return lotto;
    }

    private static LottoNumber getLottoNumber() {
        return new LottoNumber(getRandomNumber());
    }

    private static int getRandomNumber() {
        return (RANDOM.nextInt(MAX_NUMBER) + MIN_NUMBER);
    }
}
