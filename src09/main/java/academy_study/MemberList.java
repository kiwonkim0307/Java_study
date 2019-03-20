package academy_study;

import java.util.Arrays;

import academy_study.domain.Member;
import academy_study.domain.Member;

public class MemberList {

	int size =1;
	int l= 0;
	Member[] members ;


	public MemberList() {
		this.members = new Member[size];
	}

	public MemberList(int newSize) {
		if (size > newSize) {
			members = new Member[size];
		}
		else
			members = new Member[newSize];
	}
	
	public void add(Member lesson) {
		if( l >= size ) {
			int oc = members.length;
			System.out.println(oc);
			int nc = oc + (oc << 2);
			System.out.println(nc);
			members = Arrays.copyOf(members, nc);

		}
		members[l++] = lesson;
		System.out.println("저장되었습니다");
	}

	public Member[] toArray() {
		//		Arrays.copyOf(members, l);
		//		Member[] list = new Member[l];
		//		for(int i=0; i<l; i++) {
		//		
		//			list[i] = members[i];
		//		}
		//		
		return Arrays.copyOf(members, l);
	}

}
