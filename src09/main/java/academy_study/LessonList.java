package academy_study;

import java.util.Arrays;

import academy_study.domain.Lesson;

public class LessonList {

	int size =1;
	int l= 0;
	Lesson[] lessons ;


	public LessonList() {
		this.lessons = new Lesson[size];
	}

	public LessonList(int newSize) {
		if (size > newSize) {
			lessons = new Lesson[size];
		}
		else
			lessons = new Lesson[newSize];
	}
	
	public void add(Lesson lesson) {
		if( l >= size ) {
			int oc = lessons.length;
			System.out.println(oc);
			int nc = oc + (oc << 2);
			System.out.println(nc);
			lessons = Arrays.copyOf(lessons, nc);

		}
		lessons[l++] = lesson;
		System.out.println("저장되었습니다");
	}

	public Lesson[] toArray() {
		//		Arrays.copyOf(lessons, l);
		//		Lesson[] list = new Lesson[l];
		//		for(int i=0; i<l; i++) {
		//		
		//			list[i] = lessons[i];
		//		}
		//		
		return Arrays.copyOf(lessons, l);
	}

}
