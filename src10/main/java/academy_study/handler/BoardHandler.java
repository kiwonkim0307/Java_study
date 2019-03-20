package academy_study.handler;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardHandler {
	Scanner kb;
	ArrayList bl =new ArrayList(1);
	public BoardHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listBoard() {
		Object[] list =bl.toArray();
		for(Object board : list) {
			Board boards = (Board) board; 
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
