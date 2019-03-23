package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardUpdateCommand implements Command{
	Scanner kb;
	ArrayList<Board> list;

	public BoardUpdateCommand(ArrayList<Board> list, Scanner kb) {
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
		Board b = list.get(index);

		try {
			Board temp = b.clone();
			System.out.printf("내용(%s)\n",b.getContents());
			String input = kb.nextLine();
			if(input.length()>0) {
				temp.setContents(input);
			}
			list.set(index, temp);

		} catch (CloneNotSupportedException e) {
			System.out.println("변경중 에러");
		}
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
