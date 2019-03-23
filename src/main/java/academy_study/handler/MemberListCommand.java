package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberListCommand implements Command{
	Scanner kb;
	ArrayList<Member> list;
	
	 public MemberListCommand(ArrayList<Member> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {
		Member[] mm	= list.toArray(new Member[] {});
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
}
