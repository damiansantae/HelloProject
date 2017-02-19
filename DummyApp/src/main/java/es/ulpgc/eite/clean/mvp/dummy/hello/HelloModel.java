package es.ulpgc.eite.clean.mvp.dummy.hello;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class HelloModel extends GenericModel<Hello.ModelToPresenter>
    implements Hello.PresenterToModel {

  private String helloText;
    private String byeLabel;
  private String helloLabel;
  private String helloLabel2;
  private int numOfTimes;
  private String msgText;

  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(Hello.ModelToPresenter presenter) {
    super.onCreate(presenter);

    helloLabel = "Say Hello";
    helloLabel2="Go to Bye";
    helloText = "Hello World!";
      byeLabel="Bye World";
  }

  /**
   * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
   * Usefull for kill/stop activities that could be running on the background Threads
   *
   * @param isChangingConfiguration Informs that a change is occurring on the configuration
   */
  @Override
  public void onDestroy(boolean isChangingConfiguration) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To Model ////////////////////////////////////////////////////////////


  @Override
  public void onChangeMsgByBtnClicked() {
    msgText = helloText;
    if(numOfTimes > 0) {
      msgText += ", " + numOfTimes + " times";
    }
    numOfTimes++;
  }

  @Override
  public String getText() {
    return helloText;
  }
    @Override
    public String getTextBye() {
        return byeLabel;
    }


  @Override
  public String getLabel() {
    return helloLabel;
  }


  @Override
  public String getLabel2() {
    return helloLabel2;
  }
}

