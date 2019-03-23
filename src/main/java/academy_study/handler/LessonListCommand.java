package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Lesson;

public class LessonListCommand implements Command{
	Scanner kb;
	ArrayList<Lesson> list;
	
	 public LessonListCommand(ArrayList<Lesson> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {
		Lesson[] lessons = list.toArray(new Lesson[] {});
		for(Lesson list : lessons) {
			System.out.printf("%d, %s    ,%s ~ %s,  %d\n",
					list.getNo(),
					list.getTitle(),
					list.getStart_day(),
					list.getEnd_day(),
					list.getTotal_time());
		}
	}
}
