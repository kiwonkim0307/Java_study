package academy_study;

public class DataLoaderListener implements ApplicationContextListener{
@Override
public void start() {
  System.out.println("데이터를 읽어옵니다");
  App.loadBoardData();
  App.loadMemberData();
  try {
    App.loadLessonData();
  } catch (Exception e) {
    e.printStackTrace();
  }

  
}


@Override
  public void end() {
  System.out.println("데이터를 저장합니다");
  App.saveBoardData();
  App.saveLessonData();
  App.saveMemberData();
  }
}
