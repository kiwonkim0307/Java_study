package academy_study.handler;
import java.util.Scanner;

import academy_study.BoardList;
import academy_study.domain.Board;

public class BoardHandler {
	Scanner kb;
	BoardList bl =new BoardList(1);
	public BoardHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listBoard() {
		Board[] list =bl.toArray();
		for(Board boards : list) {
			System.out.printf("%d, %s    ,%s , %d\n",
					boards.getNo(),
					boards.getContents(),
					boards.getDate(),
					boards.getCount());
		}
	}

	public  void addBoard() {
		Board board = new Board();
		System.out.print("번호? ");
		board.setNo(Integer.parseInt(kb.nextLine()));
		System.out.print("내용? ");
		board.setContents(kb.nextLine());
		

		bl.add(board);
		
	}
}
