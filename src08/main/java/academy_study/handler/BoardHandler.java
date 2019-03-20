package academy_study.handler;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardHandler {
	Scanner kb;
	int size =10;
	int b= 0;
	Board[] boards = new Board[size];

	public BoardHandler(Scanner kb) {
		this.kb = kb;
	}

	public  void listBoard() {
		for(int j =0; j<b ; j++) {
			System.out.printf("%d, %s    ,%s , %d\n",
					boards[j].getNo(),
					boards[j].getContents(),
					boards[j].getDate(),
					boards[j].getCount());
		}
	}

	public  void addBoard() {
		Board board = new Board();
		System.out.print("번호? ");
		board.setNo(Integer.parseInt(kb.nextLine()));
		System.out.print("내용? ");
		board.setContents(kb.nextLine());
		System.out.println("저장되었습니다");
		boards[b++] = board;
		
	}
}
