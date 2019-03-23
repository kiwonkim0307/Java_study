package academy_study;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import academy_study.handler.BoardHandler;
import academy_study.handler.LessonHandler;
import academy_study.handler.MemberHandler;
//24번 할 차례
public class App {

	static Scanner kb = new Scanner(System.in);
	static	int size =10;
	static	Stack<String> st = new Stack<>();
	static	Queue<String> ut = new LinkedList<>();;

	public static void main(String[]  args) {

		LessonHandler lh = new LessonHandler(kb, new LinkedList<>());
		BoardHandler bh = new BoardHandler(kb,new ArrayList<>());
		MemberHandler mh = new MemberHandler(kb, new ArrayList<>());
		App app = new App();


		while(true) {	
			System.out.print("명령> ");
			String command = kb.nextLine();

			st.push(command);	

			ut.offer(command);

			if(command.equals("/lesson/add")) {
				lh.addLesson();
			}else if(command.equals("/lesson/list")) {
				lh.listLesson();
			}else if(command.equals("/lesson/detail")) {
				lh.detailLesson();
			}else if(command.equals("/lesson/update")) {
				lh.updateLesson();
			}else if(command.equals("/lesson/delete")) {
				lh.deleteLesson();
			}else if(command.equals("/member/add")) {
				mh.addMember();
			}else if(command.equals("/member/list")){
				mh.listMember();
			}else if(command.equals("/member/detail")){
				mh.detailMember();
			}else if(command.equals("/member/update")){
				mh.updateMember();
			}else if(command.equals("/member/delete")){
				mh.deleteMember();
			}else if(command.equals("/board/add")){
				bh.addBoard();
			}else if(command.equals("/board/list")) {
				bh.listBoard();
			}else if(command.equals("/board/detail")) {
				bh.detailBoard();
			}else if(command.equals("/board/update")) {
				bh.updateBoard();
			}else if(command.equals("/board/delete")) {
				bh.deleteBoard();
			}else if(command.equals("/history")) {
				app.printCommandHistory();
			}else if(command.equals("/history2")) {
				app.printCommandHistory2();
			}else if(command.equalsIgnoreCase("q")) {
				System.out.println("잘가요~");
				kb.close();
				break;
			}
			else 
				System.out.println("잘못된 명령어 입니다.");
		}//while
	}//main


	private  void printCommandHistory2() {
		Iterator <String> stiterator = ut.iterator();
		while(stiterator.hasNext())
			System.out.println(stiterator.next());

	}
	public  void printCommandHistory() {
		Iterator <String> stiterator = st.iterator();
		while(stiterator.hasNext())
			System.out.println(stiterator.next());

	}


}
