package academy_study.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import academy_study.context.ApplicationListener;
import academy_study.domain.Board;

public class BoardDataLoaderListener implements ApplicationListener{

	@Override
	public void startApplication(Map<String, Object> context) {

			    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

			      int length = in.readInt();

			      for (int i = 0; i < length; i++) {
			        blist.add((Board)in.readObject());
			      }

			    } catch (Exception e) {
			      System.out.println("게시글 데이터를 읽는 중 오류 발생: " + e.toString());

			    } finally {
			      try {in.close();} catch (Exception e) {}
			    }

	}

	@Override
	public void endApplication(Map<String, Object> context) {
		    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(
		        new FileOutputStream("board.bin2")))) {

		      out.writeInt(blist.size());

		      for (Board b : blist) {
		        out.writeObject(b);
		      }

		    } catch (Exception e) {
		      System.out.println("게시글 데이터를 쓰는 중 오류 발생: " + e.toString());
		    }
	}

}
