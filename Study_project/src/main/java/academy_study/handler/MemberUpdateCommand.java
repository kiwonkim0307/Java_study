package academy_study.handler;

import java.util.ArrayList;
import java.util.Scanner;

import academy_study.domain.Member;

public class MemberUpdateCommand implements Command{
	Scanner kb;
	ArrayList<Member> list;

	public MemberUpdateCommand(ArrayList<Member> list, Scanner kb) {
		this.list = list;
		this.kb = kb;
	}

	@Override
	public void excute() {

		System.out.print("번호? ");
		String input ;
		int no = Integer.parseInt(kb.nextLine());
		int index = IndexOfMember(no);
		if(index == -1) {
			System.out.println("해당 번호가 없습니다");
			return;
		}
		Member m= list.get(index);
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
		list.set(index, temp);
		System.out.println("업뎃성공");
		
		} catch (CloneNotSupportedException e) {
			System.out.println("업데이트중 오류발생");
		}
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
