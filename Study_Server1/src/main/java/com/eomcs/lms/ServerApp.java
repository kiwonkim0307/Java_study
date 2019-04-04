package com.eomcs.lms;

// 5번 할차례
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.eomcs.lms.domain.Board;

public class ServerApp {

	public static void main(String[] args) {

		try(ServerSocket ss = new ServerSocket(8888)){
			System.out.println("서버연결됨");

			while(true) {
				try(Socket sk = ss.accept();
						ObjectInputStream in = new ObjectInputStream(sk.getInputStream());
						ObjectOutputStream out = new ObjectOutputStream(sk.getOutputStream())){
					System.out.println("클라와 연결됨");

			Board b =	(Board)in.readObject();
			
			System.out.printf("번호%d, 내용%s\n",b.getNo(),b.getContents());
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("클라와 연결 끊");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}

	}	

}
