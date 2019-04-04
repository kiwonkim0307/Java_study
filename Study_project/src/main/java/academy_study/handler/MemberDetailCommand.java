package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberDetailCommand implements Command{
	Scanner kb;
	ArrayList<Member> list;
	
	 public MemberDetailCommand(ArrayList<Member> list, Scanner kb) {
		 this.list = list;
		 this.kb = kb;
	}
	
	@Override
	public void excute() {

		System.out.print("번호? ");
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfMember(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Member m = list.get(index);
		
		System.out.printf("%d\n%s\n%s\n%s\n%s\n%s\n%s\n",
				m.getNo(),
				m.getName(),
				m.getEmail(),
				m.getPassword(),
				m.getPhoto(),
				m.getTell(),
				m.getDate());
	}
	
	private int IndexOfMember(int no) {
		for(int i =0; i<list.size(); i++) {
			Member b = list.get(i);
			if(b.getNo() == no) {
				return i;
			}
		}
		return -1;
	}
	
	
}
