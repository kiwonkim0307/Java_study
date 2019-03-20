package academy_study.handler;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberHandler {

	Scanner kb;
	int size =10;
	int m= 0;
	Member[] members = new Member[size];

	public MemberHandler(Scanner kb) {
		this.kb = kb;
	}

	public void listMember() {
		for(int j =0; j< m ; j++) {
			System.out.printf("%d, %s    ,%s , %s,  %s\n",
					members[j].getNo(),
					members[j].getName(),
					members[j].getEmail(),
					members[j].getTell(),
					members[j].getDate());
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

		members[m++] = member;
		System.out.println("저장하였습니다.");
	}



}
