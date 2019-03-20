package academy_study;

import java.util.Arrays;

import academy_study.domain.Board;
import academy_study.domain.Board;

public class BoardList {

	int size =1;
	int l= 0;
	Board[] boards ;


	public BoardList() {
		this.boards = new Board[size];
	}

	public BoardList(int newSize) {
		if (size > newSize) {
			boards = new Board[size];
		}
		else
			boards = new Board[newSize];
	}
	
	public void add(Board lesson) {
		if( l >= size ) {
			int oc = boards.length;
			System.out.println(oc);
			int nc = oc + (oc << 2);
			System.out.println(nc);
			boards = Arrays.copyOf(boards, nc);

		}
		boards[l++] = lesson;
		System.out.println("저장되었습니다");
	}

	public Board[] toArray() {
		//		Arrays.copyOf(boards, l);
		//		Board[] list = new Board[l];
		//		for(int i=0; i<l; i++) {
		//		
		//			list[i] = boards[i];
		//		}
		//		
		return Arrays.copyOf(boards, l);
	}

}
