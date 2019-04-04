package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;
import academy_study.domain.Lesson;

public class LessonDetailCommand implements Command{
	Scanner kb;
	ArrayList<Lesson> list;
	
	 public LessonDetailCommand(ArrayList<Lesson> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());

		int index = IndexOfLesson(no);
		if (index == -1) {
			System.out.println("해당 수업을 찾을 수 없습니다.");
			return;
		}

		Lesson lesson = list.get(index);

		System.out.printf("수업명: %s\n", lesson.getTitle());
		System.out.printf("설명: %s\n", lesson.getContents());
		System.out.printf("기간: %s ~ %s\n", lesson.getStart_day(), lesson.getEnd_day());
		System.out.printf("총수업시간: %d\n", lesson.getTotal_time());
		System.out.printf("일수업시간: %d\n", lesson.getDay_time());
	}
	
	
	private int IndexOfLesson(int no) {
		for(int i =0; i<list.size(); i++) {
			Lesson b = list.get(i);
			if(b.getNo() == no) {
				return i;
			}
		}
		return -1;
	}
	
	
}
