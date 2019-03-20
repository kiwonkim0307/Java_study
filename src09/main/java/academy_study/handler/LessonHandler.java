package academy_study.handler;
import java.sql.Date;
import java.util.Scanner;

import academy_study.LessonList;
import academy_study.domain.Lesson;

public class LessonHandler {

	Scanner kb;

	LessonList ll = new LessonList();

	public LessonHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listLesson() {
	 Lesson[] lessons = ll.toArray();
		for(Lesson list : lessons) {
			System.out.printf("%d, %s    ,%s ~ %s,  %d\n",
					list.getNo(),
					list.getTitle(),
					list.getStart_day(),
					list.getEnd_day(),
					list.getTotal_time());
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

		ll.add(lesson);
		
	}

}
