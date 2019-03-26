package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;
import academy_study.domain.Lesson;

public class LessonUpdateCommand implements Command{
	Scanner kb;
	ArrayList<Lesson> list;

	public LessonUpdateCommand(ArrayList<Lesson> list, Scanner kb) {
		this.list = list;
		this.kb = kb;
	}

	@Override
	public void excute() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = indexOfLesson(no);
		if(index == -1) {
			System.out.println("해당 수업을 찾을수 없습니다");
			return;
		}
		Lesson lesson = list.get(index);

		try {
			Lesson temp = lesson.clone();

			System.out.printf("수업명(%s)? ", lesson.getTitle());
			String input = kb.nextLine();
			if (input.length() > 0) 
				temp.setTitle(input);

			System.out.printf("설명(%s)? ", lesson.getContents());
			if ((input = kb.nextLine()).length() > 0)
				temp.setContents(input);

			System.out.printf("시작일(%s)? ", lesson.getStart_day());
			if ((input = kb.nextLine()).length() > 0)
				temp.setStart_day(Date.valueOf(input));

			System.out.printf("종료일(%s)? ", lesson.getEnd_day());
			if ((input = kb.nextLine()).length() > 0)
				temp.setEnd_day(Date.valueOf(input));

			System.out.printf("총수업시간(%d)? ", lesson.getTotal_time());
			if ((input = kb.nextLine()).length() > 0)
				temp.setTotal_time(Integer.parseInt(input));

			System.out.printf("일수업시간(%d)? ", lesson.getDay_time());
			if ((input = kb.nextLine()).length() > 0)
				temp.setDay_time(Integer.parseInt(input));

			list.set(index, temp);

			System.out.println("수업을 변경했습니다.");

		} catch (Exception e) {
			System.out.println("변경 중 오류 발생!");
		}
	}
	
	private int indexOfLesson(int no) {
		for(int i =0; i<list.size(); i++) {
			Lesson b = list.get(i);
			if(b.getNo() == no) {
				return i;
			}
		}
		return -1;
	}

}
