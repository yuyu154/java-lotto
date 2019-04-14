package util;

import java.util.Random;

public class RandomNumberMaker {
    private static final Random RANDOM = new Random();

    public static int getRandomNumber(int maxNum, int minNum) {
        return (RANDOM.nextInt(maxNum) + minNum);
    }
}
