package academy_study.util;

import java.util.Arrays;

public class ArrayList<E> {
	
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
	
	public void add(E obj) {
		if( l >= size ) {
			int oc = objs.length;
			int nc = oc + (oc << 2);
			objs = Arrays.copyOf(objs, nc);
		}
		objs[l++] = obj;
		System.out.println("저장되었습니다");
	}

	@SuppressWarnings("unchecked")
	public E[] toArray(E[] obj) {
		
		//		Object[] list = new Object[l];
		//		for(int i=0; i<l; i++) {
		//		
		//			list[i] = objs[i];
		//		}
		//		
		return (E[])Arrays.copyOf(objs, l, obj.getClass());
	}

}
