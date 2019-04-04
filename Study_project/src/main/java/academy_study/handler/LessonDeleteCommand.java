package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;
import academy_study.domain.Lesson;

public class LessonDeleteCommand implements Command{
	Scanner kb ;
	ArrayList<Lesson> list;

	public LessonDeleteCommand(ArrayList<Lesson> list, Scanner kb) {
		this.list = list;
		this.kb = kb;
	}


	@Override
	public void excute() {

		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());

		int index = indexOfLesson(no);
		if (index == -1) {
			System.out.println("해당 수업을 찾을 수 없습니다.");
			return;
		}

		list.remove(index);

		System.out.println("수업을 삭제했습니다.");
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
