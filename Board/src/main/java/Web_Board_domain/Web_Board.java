package Web_Board_domain;

public class Web_Board {

	private int id;// 게시글의 ID
	private String title;// 게시글의 제목
	private String date;// 게시글의 날짜
	private String content;// 게시글의 내용
	private int keyNum;// 게시글의 키 번호
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getKeyNum() {
		return keyNum;
	}
	public void setKeyNum(int keyNum) {
		this.keyNum = keyNum;
	}
	
	
}
