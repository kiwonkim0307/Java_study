package academy_study;

public class DataLoaderListener implements ApplicationContextListener{
@Override
public void Start() {
  
  App.loadBoardData();
  App.loadMemberData();
  try {
    App.loadLessonData();
  } catch (Exception e) {
    e.printStackTrace();
  }

  
}


@Override
  public void End() {
    
  }
}
