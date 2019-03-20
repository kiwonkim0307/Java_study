package academy_study.handler;

import java.util.Arrays;

public class ArrayList {
	
	int size =1;
	int l= 0;
	Object[] objs ;


	public ArrayList() {
		this.objs = new Object[size];
	}

	public ArrayList(int newSize) {
		if (size > newSize) {
			objs = new Object[size];
		}
		else
			objs = new Object[newSize];
	}
	
	public void add(Object lesson) {
		if( l >= size ) {
			int oc = objs.length;
			System.out.println(oc);
			int nc = oc + (oc << 2);
			System.out.println(nc);
			objs = Arrays.copyOf(objs, nc);
		}
		objs[l++] = lesson;
		System.out.println("저장되었습니다");
	}

	public Object[] toArray() {
		
		//		Object[] list = new Object[l];
		//		for(int i=0; i<l; i++) {
		//		
		//			list[i] = objs[i];
		//		}
		//		
		return Arrays.copyOf(objs, l);
	}

}
