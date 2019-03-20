package academy_study;
import java.util.Scanner;

import academy_study.handler.BoardHandler;
import academy_study.handler.LessonHandler;
import academy_study.handler.MemberHandler;

public class App {

	static Scanner kb = new Scanner(System.in);
	static	int size =10;

	public static void main(String[]  args) {
		
		LessonHandler lh = new LessonHandler(kb);
		BoardHandler bh = new BoardHandler(kb);
		MemberHandler mh = new MemberHandler(kb);

		while(true) {	
			System.out.print("명령> ");
			String command = kb.nextLine();

			if(command.equals("/lesson/add")) {
				lh.addLesson();
			}else if(command.equals("/lesson/list")) {
				lh.listLesson();
			}else if(command.equals("/member/add")) {
				mh.addMember();
			}else if(command.equals("/member/list")){
				mh.listMember();
			}else if(command.equals("/board/add")){
				bh.addBoard();
			}else if(command.equals("/board/list")) {
				bh.listBoard();
			}else if(command.equalsIgnoreCase("q")) {
				System.out.println("잘가요~");
				kb.close();
				break;
			}
			else 
				System.out.println("잘못된 명령어 입니다.");
		}//while
	}//main







}
