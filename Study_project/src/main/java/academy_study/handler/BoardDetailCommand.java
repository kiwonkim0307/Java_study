package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardDetailCommand implements Command{
	Scanner kb;
	ArrayList<Board> list;
	
	 public BoardDetailCommand(ArrayList<Board> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfBoard(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Board b =  list.get(index);
		System.out.printf("%d, %s, %s, %d\n",
				b.getNo(),
				b.getContents(),
				b.getDate(),
				b.getCount());
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
