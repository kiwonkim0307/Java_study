package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;
import academy_study.domain.Lesson;

public class LessonAddCommand implements Command{
	Scanner kb;
	ArrayList<Lesson> list;
	
	 public LessonAddCommand(ArrayList<Lesson> list , Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

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

		list.add(lesson);


	}
}
