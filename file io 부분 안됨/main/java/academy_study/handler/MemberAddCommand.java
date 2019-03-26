package academy_study.handler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberAddCommand implements Command{
	Scanner kb;
	ArrayList<Member> list;
	
	 public MemberAddCommand(ArrayList<Member> list , Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {
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
		
		list.add(m);
		System.out.println("저장");
	}
}
