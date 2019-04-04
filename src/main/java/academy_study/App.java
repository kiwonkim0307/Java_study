package academy_study;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import academy_study.context.ApplicationListener;
import academy_study.domain.Board;
import academy_study.domain.Lesson;
import academy_study.domain.Member;
import academy_study.handler.BoardAddCommand;
import academy_study.handler.BoardDeleteCommand;
import academy_study.handler.BoardDetailCommand;
import academy_study.handler.BoardListCommand;
import academy_study.handler.BoardUpdateCommand;
import academy_study.handler.Command;
import academy_study.handler.LessonAddCommand;
import academy_study.handler.LessonDeleteCommand;
import academy_study.handler.LessonDetailCommand;
import academy_study.handler.LessonListCommand;
import academy_study.handler.LessonUpdateCommand;
import academy_study.handler.MemberAddCommand;
import academy_study.handler.MemberDeleteCommand;
import academy_study.handler.MemberDetailCommand;
import academy_study.handler.MemberListCommand;
import academy_study.handler.MemberUpdateCommand;
import academy_study.listener.BoardDataLoaderListener;
//31번 할 차례
public class App {

	static ArrayList<ApplicationListener>observers = new ArrayList<>();

	static HashMap<String,Object> context = new HashMap<>();

	static {
		context.put("kb", new Scanner(System.in));
		context.put("blist",  new ArrayList<Board>());
		context.put("llist",  new ArrayList<Lesson>());
		context.put("mlist",  new ArrayList<Member>());
		context.put("st",  new Stack<String>());
		context.put("ut",  new LinkedList<String>());
	}

	static void addApplicationListner(ApplicationListener listener) {
		observers.add(listener);
	}


	@SuppressWarnings("unchecked")
	public static void main(String[]  args) throws Exception {

		addApplicationListner(new BoardDataLoaderListener());

		for(ApplicationListener observer : observers) {
			observer.startApplication(context);
		}

		Scanner kb = (Scanner) context.get("kb");
		ArrayList<Board> blist  =(ArrayList<Board>)context.get("blist");
		ArrayList<Lesson> llist  =(ArrayList<Lesson>)context.get("llist");
		ArrayList<Member> mlist  =(ArrayList<Member>)context.get("mlist");
		Stack<String> st = (Stack<String>)context.get("st");
		LinkedList<String> ut = (LinkedList<String>)context.get("ut");
		Map<String,Command> commandMap = new HashMap<>();

		commandMap.put("/board/add", new BoardAddCommand(blist,kb));
		commandMap.put("/board/list", new BoardListCommand(blist,kb));
		commandMap.put("/board/detail", new BoardDetailCommand(blist,kb));
		commandMap.put("/board/update", new BoardUpdateCommand(blist,kb));
		commandMap.put("/board/delete", new BoardDeleteCommand(blist,kb));

		commandMap.put("/lesson/add", new LessonAddCommand(llist,kb));
		commandMap.put("/lesson/list", new LessonListCommand(llist,kb));
		commandMap.put("/lesson/detail", new LessonDetailCommand(llist,kb));
		commandMap.put("/lesson/update", new LessonUpdateCommand(llist,kb));
		commandMap.put("/lesson/delete", new LessonDeleteCommand(llist,kb));

		commandMap.put("/member/add", new MemberAddCommand(mlist,kb));
		commandMap.put("/member/list", new MemberListCommand(mlist,kb));
		commandMap.put("/member/detail", new MemberDetailCommand(mlist,kb));
		commandMap.put("/member/update", new MemberUpdateCommand(mlist,kb));
		commandMap.put("/member/delete", new MemberDeleteCommand(mlist,kb));

		while(true) {	
			try {
				System.out.print("명령> ");
				String command = kb.nextLine();

				st.push(command);	
				ut.offer(command);

				Command cg =  commandMap.get(command);

				if(cg != null) {
					cg.excute();
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
			}catch(Exception e) {	
				e.printStackTrace();
			}
		}//while

	}//main


	public static void saveMemberData() {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream("member.bin2")))) {

			// 첫 번째로 데이터의 개수(int)를 먼저 출력 한다.
			out.writeInt(mlist.size());

			for (Member m : mlist) {
				out.writeObject(m);
			}

		} catch (Exception e) {
			System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
		}
	}


	public static void loadMemberData() {
		ObjectInputStream in = null;

		try {

			File file = new File("member.bin2");
			if (!file.exists()) {
				file.createNewFile();
				return;
			}

			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

			// 파일의 첫 번째 데이터가 저장된 데이터의 개수(int)이다.
			int length = in.readInt();

			for (int i = 0; i < length; i++) {
				mlist.add((Member)in.readObject());
			}

		} catch (Exception e) {
			System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());

		} finally {
			try {in.close();} catch (Exception e) {}
		}
	}

	public static void loadLessonData() throws Exception {
		File file = new File("lesson2.data");
		if (!file.exists()) {
			file.createNewFile();
			return;
		}
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("lesson2.data")))){

			int len = in.readInt();

			for(int i=0; i <len; i++) {
				llist.add((Lesson)in.readObject());
			}

		} catch (Exception e) {
			System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());

		} 
	}

	public static void saveLessonData() {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("lesson2.data")))) {
			out.writeInt(llist.size());

			for(Lesson l : llist) {
				out.writeObject(l);
			}

		} catch (Exception e) {
			System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
		}
	}



	public static void printCommandHistory2() {
		
		Iterator <String> stiterator = ut.iterator();
		while(stiterator.hasNext())
			System.out.println(stiterator.next());

	}
	public static void printCommandHistory() {
		Iterator <String> stiterator = st.iterator();
		while(stiterator.hasNext())
			System.out.println(stiterator.next());

	}


}
