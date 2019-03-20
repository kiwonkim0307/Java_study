package academy_study.domain;
import java.sql.Date;

public class Lesson {
	private	int no ;
	private	String title ;
	private	String contents;
	private	Date start_day ;
	private	Date end_day ;
	private	int total_time ;
	private	int day_time ;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getStart_day() {
		return start_day;
	}
	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}
	public Date getEnd_day() {
		return end_day;
	}
	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}
	public int getTotal_time() {
		return total_time;
	}
	public void setTotal_time(int total_time) {
		this.total_time = total_time;
	}
	public int getDay_time() {
		return day_time;
	}
	public void setDay_time(int day_time) {
		this.day_time = day_time;
	}
	
	
}
