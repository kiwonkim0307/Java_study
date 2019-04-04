package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardListCommand implements Command{
	Scanner kb;
	ArrayList<Board> list;
	
	 public BoardListCommand(ArrayList<Board> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

		Board [] board = list.toArray(new Board[]{});	
		for(Board b : board) {
			System.out.printf("%d, %s, %s, %d\n",
					b.getNo(),
					b.getContents(),
					b.getDate(),
					b.getCount());
		}
	}
}
