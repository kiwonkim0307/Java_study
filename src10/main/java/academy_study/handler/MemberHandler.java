package academy_study.handler;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberHandler {

	Scanner kb;
	ArrayList ml = new ArrayList(20);

	public MemberHandler(Scanner kb) {
		this.kb = kb;
	}

	public void listMember() {
		Object[] list= ml.toArray();
		for(Object member : list) {
			Member members = (Member)member;
			System.out.printf("%d, %s    ,%s , %s,  %s\n",
					members.getNo(),
					members.getName(),
					members.getEmail(),
					members.getTell(),
					members.getDate());
		}
	}
	public  void addMember() {
		Member member = new Member();
		System.out.print("번호? ");
		member.setNo(Integer.parseInt(kb.nextLine())) ;
		System.out.print("이름? ");
		member.setName(kb.nextLine()) ;
		System.out.print("이메일? ");
		member.setEmail(kb.nextLine());;
		System.out.print("암호? ");
		member.setPassword(kb.nextLine());;
		System.out.print("사진? ");
		member.setPhoto(kb.nextLine());;
		System.out.print("전화? ");
		member.setTell(kb.nextLine());;

		ml.add(member);

	}



}
