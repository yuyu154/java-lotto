package domain;

public class LottoNumber {
    private  static final  int MAX_NUMBER = 45;
    private  static final int MIN_NUMBER = 1;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int intValue() {
        return this.lottoNumber;
    }

    private void checkValidNumber() {
        if (lottoNumber < MIN_NUMBER || lottoNumber < MAX_NUMBER) {
            throw new IllegalArgumentException("1에서 45사이의 숫자를 입력하세요");
        }
    }
}
