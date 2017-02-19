package es.ulpgc.eite.clean.mvp.dummy.bye;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class ByeModel extends GenericModel<Bye.ModelToPresenter>
    implements Bye.PresenterToModel {

  private String byeText;
  private String helloMsg;
  private String byeLabel;
  private String byeLabel2;
  //private int numOfTimes;
 // private String msgText;


  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(Bye.ModelToPresenter presenter) {
    super.onCreate(presenter);

    byeLabel = "Say Bye";
    byeLabel2 = "Back to Hello";
    byeText = "Bye World!";
    helloMsg ="Hello World!";
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
//    msgText = byeText;
//    if(numOfTimes > 0) {
//      msgText += ", " + numOfTimes + " times";
//    }
//    numOfTimes++;
  }

  @Override
  public String getText() {
    return byeText;
  }

  @Override
  public String getLabel() {
    return byeLabel;
  }

  @Override
  public String getLabel2() {
    return byeLabel2;
  }

  @Override
  public String getText1() {
    return helloMsg;
  }
}

