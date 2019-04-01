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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
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
//31번 할 차례
public class App {


  static ArrayList<Board> blist = new ArrayList<>();
  static ArrayList<Lesson> llist = new ArrayList<>();
  static ArrayList<Member> mlist = new ArrayList<>();
  static Scanner kb = new Scanner(System.in);
  static	int size =10;
  static	Stack<String> st = new Stack<>();
  static	Queue<String> ut = new LinkedList<>();;

  public static void main(String[]  args) throws Exception {

    HashMap<String,Object>observers = new HashMap<>();
    observers.put("observer", new DataLoaderListener());

    ApplicationContextListener dataobserver = (ApplicationContextListener)observers.get("observer");
    dataobserver.start();


    HashMap<String,Object>map = new HashMap<>();

    App app = new App();

    map.put("/board/add", new BoardAddCommand(blist,kb));
    map.put("/board/list", new BoardListCommand(blist,kb));
    map.put("/board/detail", new BoardDetailCommand(blist,kb));
    map.put("/board/update", new BoardUpdateCommand(blist,kb));
    map.put("/board/delete", new BoardDeleteCommand(blist,kb));

    map.put("/lesson/add", new LessonAddCommand(llist,kb));
    map.put("/lesson/list", new LessonListCommand(llist,kb));
    map.put("/lesson/detail", new LessonDetailCommand(llist,kb));
    map.put("/lesson/update", new LessonUpdateCommand(llist,kb));
    map.put("/lesson/delete", new LessonDeleteCommand(llist,kb));

    map.put("/member/add", new MemberAddCommand(mlist,kb));
    map.put("/member/list", new MemberListCommand(mlist,kb));
    map.put("/member/detail", new MemberDetailCommand(mlist,kb));
    map.put("/member/update", new MemberUpdateCommand(mlist,kb));
    map.put("/member/delete", new MemberDeleteCommand(mlist,kb));

    while(true) {	
      try {
        System.out.print("명령> ");
        String command = kb.nextLine();

        st.push(command);	
        ut.offer(command);

        Command cg = (Command) map.get(command);

        if(cg != null) {
          cg.excute();
        }else if(command.equals("/history")) {
          app.printCommandHistory();

        }else if(command.equals("/history2")) {
          app.printCommandHistory2();
        }else if(command.equalsIgnoreCase("q")) {
          System.out.println("잘가요~");
          dataobserver.end();
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
  public static void loadBoardData() {
    ObjectInputStream in = null;

    try {

      File file = new File("board.bin2");
      if (!file.exists()) {
        file.createNewFile();
        return;
      }

      in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

      int length = in.readInt();

      for (int i = 0; i < length; i++) {
        blist.add((Board)in.readObject());
      }

    } catch (Exception e) {
      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());

    } finally {
      try {in.close();} catch (Exception e) {}
    }
  }

  public static void saveBoardData() {
    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
        new FileOutputStream("board.bin2")))) {

      out.writeInt(blist.size());

      for (Board b : blist) {
        out.writeObject(b);
      }

    } catch (Exception e) {
      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }

  public  void printCommandHistory2() {
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
