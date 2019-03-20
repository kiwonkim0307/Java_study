package academy_study.handler;
import java.sql.Date;
import java.util.Scanner;

import academy_study.domain.Lesson;

public class LessonHandler {

	Scanner kb;
	int size =10;
	int l= 0;
	Lesson[] lessons = new Lesson[size];

	public LessonHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listLesson() {
		for(int j = 0; j<l ; j++) {
			System.out.printf("%d, %s    ,%s ~ %s,  %d\n",
					lessons[j].getNo(),
					lessons[j].getTitle(),
					lessons[j].getStart_day(),
					lessons[j].getEnd_day(),
					lessons[j].getTotal_time());
		}
	}

	public  void addLesson() {
		Lesson lesson = new Lesson();

		System.out.print("번호? ");
		lesson.setNo(Integer.parseInt(kb.nextLine()));
		System.out.print("수업명? ");
		lesson.setTitle(kb.nextLine()); 
		System.out.print("수업내용? ");
		lesson.setContents(kb.nextLine()); 
		System.out.print("시작일? ");
		lesson.setStart_day(Date.valueOf(kb.nextLine())); 
		System.out.print("종료일? ");
		lesson.setEnd_day(Date.valueOf(kb.nextLine())); 
		System.out.print("총수업시간? ");
		lesson.setTotal_time(Integer.parseInt(kb.nextLine())); 
		System.out.print("일수업시간? ");
		lesson.setDay_time(Integer.parseInt(kb.nextLine())); 

		lessons[l++] = lesson;
		System.out.println("저장하였습니다.");
	}

}
