package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardDeleteCommand implements Command{
	Scanner kb ;
	ArrayList<Board> list;

	public BoardDeleteCommand(ArrayList<Board> list, Scanner kb) {
		this.list = list;
		this.kb = kb;
	}


	@Override
	public void excute() {

		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfBoard(no);
		if(index == -1) {
			System.out.println(" 해당 버노 없어");
			return;
		}

		list.remove(index);
		System.out.println("삭제했엄");
	}


	private int IndexOfBoard(int no) {
		for(int i =0; i<list.size(); i++) {
			Board b = list.get(i);
			if(b.getNo() == no) {
				return i;
			}
		}
		return -1;
	}

}
