package util;

import domain.Lotto;
import domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberMaker {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    private static final Random RANDOM = new Random();

    public static List<Lotto> getLottoList(int buyCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottoList.add(getRandomLotto());
        }
        return lottoList;
    }

    private static Lotto getRandomLotto() {
        return new Lotto(makeRandomIntegerList());
    }

    private static List<Integer> makeRandomIntegerList() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lotto.add(getLottoNumber().intValue());
        }
        return lotto;
    }

    private static LottoNumber getLottoNumber() {
        try {
            return new LottoNumber(getRandomNumber());
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            return getLottoNumber();
        }
    }

    private static int getRandomNumber() {
        return (RANDOM.nextInt(MAX_NUMBER) + MIN_NUMBER);
    }
}
