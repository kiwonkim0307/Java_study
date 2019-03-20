package academy_study.handler;
import java.sql.Date;
import java.util.Scanner;

import academy_study.domain.Lesson;
import academy_study.util.ArrayList;

public class LessonHandler {

	Scanner kb;

	ArrayList<Lesson> ll = new ArrayList<>();

	public LessonHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listLesson() {
		Lesson[] lessons = ll.toArray(new Lesson[] {});
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


	public void detailLesson() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());

		int index = indexOfLesson(no);
		if (index == -1) {
			System.out.println("해당 수업을 찾을 수 없습니다.");
			return;
		}

		Lesson lesson = ll.get(index);

		System.out.printf("수업명: %s\n", lesson.getTitle());
		System.out.printf("설명: %s\n", lesson.getContents());
		System.out.printf("기간: %s ~ %s\n", lesson.getStart_day(), lesson.getEnd_day());
		System.out.printf("총수업시간: %d\n", lesson.getTotal_time());
		System.out.printf("일수업시간: %d\n", lesson.getDay_time());
	}

	public void updateLesson() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = indexOfLesson(no);
		if(index == -1) {
			System.out.println("해당 수업을 찾을수 없습니다");
			return;
		}
		Lesson lesson = ll.get(index);

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

			ll.set(index, temp);

			System.out.println("수업을 변경했습니다.");

		} catch (Exception e) {
			System.out.println("변경 중 오류 발생!");
		}
	}
	
	public void deleteLesson() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());

		int index = indexOfLesson(no);
		if (index == -1) {
			System.out.println("해당 수업을 찾을 수 없습니다.");
			return;
		}

		ll.remove(index);

		System.out.println("수업을 삭제했습니다.");
	}



	@SuppressWarnings("unused")
	private int indexOfLesson(int no) {
		for (int i = 0; i < ll.size(); i++) {
			Lesson l = ll.get(i);
			if (l.getNo() == no)
				return i;
		}
		return -1;
	}

}
