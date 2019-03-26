package academy_study.domain;
import java.sql.Date;

public class Board implements Cloneable{
	private	int no ;
	private	String contents ;
	private	Date date = new Date(System.currentTimeMillis());
	private	int count = 0;
	
	@Override
	public Board clone() throws CloneNotSupportedException {
		return (Board)super.clone();
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
