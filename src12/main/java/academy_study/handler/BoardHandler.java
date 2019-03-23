package academy_study.handler;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import academy_study.domain.Board;

public class BoardHandler {
	Scanner kb;
	List<Board> bl ;
	public BoardHandler(Scanner kb ,List<Board> list) {
		this.kb = kb;
		this.bl = list;
	}

	public void listBoard() {
		Board [] board = bl.toArray(new Board[]{});	
		for(Board b : board) {
			System.out.printf("%d, %s, %s, %d\n",
					b.getNo(),
					b.getContents(),
					b.getDate(),
					b.getCount());
		}
	}

	public void addBoard() {
	try {	
		Board b = new Board();
		System.out.print("번호? ");
		b.setNo(Integer.parseInt(kb.nextLine()));
		System.out.print("내용? ");
		b.setContents(kb.nextLine());
		b.setDate(new Date(System.currentTimeMillis()));
		b.setCount(0);
		bl.add(b);
		System.out.println("저장되었습니다.");
	}catch(Exception e ) {
		e.printStackTrace();
	}
	}

	public void detailBoard() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfBoard(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Board b =  bl.get(index);
		System.out.printf("%d, %s, %s, %d\n",
				b.getNo(),
				b.getContents(),
				b.getDate(),
				b.getCount());
	}
	public void updateBoard() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfBoard(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Board b = bl.get(index);
		try {
			Board temp = b.clone();
			System.out.printf("내용(%s)\n",b.getContents());
			String input = kb.nextLine();
			if(input.length()>0) {
				temp.setContents(input);
			}
			bl.set(index, temp);

		} catch (CloneNotSupportedException e) {
			System.out.println("변경중 에러");
		}
	}

	public void deleteBoard() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfBoard(no);
		if(index == -1) {
			System.out.println(" 해당 버노 없어");
			return;
		}

		bl.remove(index);
		System.out.println("삭제했엄");
	}


	private int IndexOfBoard(int no) {
		for(int i =0; i<bl.size(); i++) {
			Board b = bl.get(i);
			if(b.getNo() == no) {
				return i;
			}
		}
		return -1;
	}
}
