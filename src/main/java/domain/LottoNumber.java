/*
 * LottoNumber.java
 */
package domain;

public class LottoNumber implements Comparable<LottoNumber> {
	private final int no;

	public LottoNumber(int no) {
		if (no < 1 || no > 45) {
			throw new IllegalArgumentException
					("1 이상 45 이하의 로또 번호를 입력하세욧");
		}
		this.no = no;
	}

	public int getLottoNumber() {
		return this.no;
	}

	@Override
	public int compareTo(LottoNumber o) {
		return new Integer(this.no).compareTo(o.getLottoNumber());
	}
}
