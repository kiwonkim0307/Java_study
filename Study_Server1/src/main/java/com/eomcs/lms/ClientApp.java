package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.eomcs.lms.domain.Board;

public class ClientApp {

	public static void main(String[] args) {

		try(
				Socket sk = new Socket("localhost",8888);
				ObjectOutputStream out = new ObjectOutputStream(sk.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(sk.getInputStream())){
			System.out.println("서버와 연결되었음");

			Board b = new Board();
			b.setContents("안녕하세요");
			b.setNo(5);

			out.writeObject(b);
			out.flush();			


		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("서버와의 연결을 끊었음");
	}	

}
