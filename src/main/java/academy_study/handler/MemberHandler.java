package academy_study.handler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberHandler {

	Scanner kb;
	ArrayList<Member> ml = new ArrayList<>(20);

	public MemberHandler(Scanner kb) {
		this.kb = kb;
	}

	public void listMember() {
		Member[] mm	= ml.toArray(new Member[] {});
		for(Member m : mm ) {
		System.out.printf("%d\n%s\n%s\n%s\n%s\n%s\n%s\n",
				m.getNo(),
				m.getName(),
				m.getEmail(),
				m.getPassword(),
				m.getPhoto(),
				m.getTell(),
				m.getDate());
		 }
		}
	public void addMember() {
		Member m = new Member();
		System.out.print("번호? ");
		m.setNo(Integer.parseInt(kb.nextLine()));
		System.out.print("이름? ");
		m.setName(kb.nextLine());
		System.out.print("이메일? ");
		m.setEmail(kb.nextLine());
		System.out.print("패스워드? ");
		m.setPassword(kb.nextLine());
		System.out.print("포토? ");
		m.setPhoto(kb.nextLine());
		System.out.print("전화번호? ");
		m.setTell(kb.nextLine());
		m.setDate(new Date(System.currentTimeMillis()));
		
		ml.add(m);
		System.out.println("저장");
	}
	public void detailMember() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfMember(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Member m = ml.get(index);
		
		System.out.printf("%d\n%s\n%s\n%s\n%s\n%s\n%s\n",
				m.getNo(),
				m.getName(),
				m.getEmail(),
				m.getPassword(),
				m.getPhoto(),
				m.getTell(),
				m.getDate());
	}
	
	public void updateMember() {
		System.out.print("번호? ");
		String input ;
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfMember(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Member m= ml.get(index);
		try {
			Member temp = m.clone();
		
		System.out.printf("이름(%s)\n",m.getName());
		 input = kb.nextLine();
		if(input.length() > 0) {
			temp.setName(input);
		}
		System.out.printf("이메일(%s)\n",m.getEmail());
		 input = kb.nextLine();
		if(input.length() > 0) {
			temp.setName(input);
		}
		System.out.printf("패쓰워드(%s)\n",m.getPassword());
		input = kb.nextLine();
		if(input.length() > 0) {
			temp.setName(input);
		}
		System.out.printf("포토(%s)\n",m.getPhoto());
	   input = kb.nextLine();
		if(input.length() > 0) {
			temp.setName(input);
		}
		System.out.printf("전화번호(%s)\n",m.getPhoto());
		 input = kb.nextLine();
		if(input.length() > 0) {
			temp.setName(input);
		}
		ml.set(index, temp);
		System.out.println("업뎃성공");
		
		} catch (CloneNotSupportedException e) {
			System.out.println("업데이트중 오류발생");
		}
	}
	public void deleteMember() {
		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfMember(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		ml.remove(index);
		System.out.println("삭제완료");
	}
	
	private int IndexOfMember(int no) {
		for(int i=0; i<ml.size(); i++) {
			 Member m = ml.get(i);
			 if(m.getNo() == no) {
				 return i;
			 }
		}
		return -1;
	}



}
