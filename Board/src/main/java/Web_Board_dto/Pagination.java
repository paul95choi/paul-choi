package Web_Board_dto;

public class Pagination {
//	Pagination 클래스는 페이지네이션에 필요한 변수를 담는 객체. 멤버 변수들은 페이지 정보를 나타내는 속성들로 구성되어 있다. 
//	getter와 setter 메서드를 통해 접근할 수 있도록 구현.
	private int c; // 현재 페이지
	private int s; // 시작 페이지
	private int e; // 블럭의 끝페이지
	private int p; // 현재페이지에서 -10페이지
	private int pp; // 맨 처음 페이지
	private int n; // 현재페이지에서 +10페이지
	private int nn; // 맨 끝 페이지

	public int getC() {
		return c;
	}

	public int setC(int c) {
		return this.c = c;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getE() {
		return e;
	}

	public int setE(int e) {
		return this.e = e;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getNn() {
		return nn;
	}

	public void setNn(int nn) {
		this.nn = nn;
	}
}
