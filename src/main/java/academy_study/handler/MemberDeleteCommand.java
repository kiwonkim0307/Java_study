package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberDeleteCommand implements Command{
	Scanner kb ;
	ArrayList<Member> list;

	public MemberDeleteCommand(ArrayList<Member> list, Scanner kb) {
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
		list.remove(index);
		System.out.println("삭제완료");
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
