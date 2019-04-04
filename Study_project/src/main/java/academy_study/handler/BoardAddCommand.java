package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardAddCommand implements Command{
	Scanner kb;
	ArrayList<Board> list;
	
	 public BoardAddCommand(ArrayList<Board> list , Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

		try {	
			Board b = new Board();
			System.out.print("번호? ");
			b.setNo(Integer.parseInt(kb.nextLine()));
			System.out.print("내용? ");
			b.setContents(kb.nextLine());
			b.setDate(new Date(System.currentTimeMillis()));
			b.setCount(0);
			list.add(b);
			System.out.println("저장되었습니다.");
		}catch(Exception e ) {
			e.printStackTrace();
		}



	}
}
