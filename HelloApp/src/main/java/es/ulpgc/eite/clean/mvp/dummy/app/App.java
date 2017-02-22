package es.ulpgc.eite.clean.mvp.dummy.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.dummy.bye.Bye;
import es.ulpgc.eite.clean.mvp.dummy.bye.ByeView;
import es.ulpgc.eite.clean.mvp.dummy.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.dummy.hello.Hello;
import es.ulpgc.eite.clean.mvp.dummy.hello.HelloView;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private HelloState toHelloState, helloToByeState, btnSayHelloClicked;
    private ByeState toByeState, byeToHelloState, btnSayByeClicked;


  @Override
  public void onCreate() {
    super.onCreate();
    toHelloState = new HelloState();
    toHelloState.toolbarVisibility = false;
    toHelloState.textVisibility = false;
      toHelloState.btnSayClicked =false;
      toHelloState.pbVisibility=false;
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Mediator //////////////////////////////////////////////////////////////////////

  @Override
  public void startingDummyScreen(Dummy.ToDummy presenter){
    if(toDummyState != null) {
      presenter.setToolbarVisibility(toDummyState.toolbarVisibility);
      presenter.setTextVisibility(toDummyState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingHelloScreen(Hello.ToHello presenter){
    //if(toHelloState != null) {
        if(helloToByeState !=null) {
            toHelloState.toolbarVisibility = helloToByeState.toolbarVisibility;
            toHelloState.textVisibility = helloToByeState.textVisibility;
            toHelloState.btnSayClicked = helloToByeState.btnSayClicked;
            toHelloState.pbVisibility =helloToByeState.pbVisibility;

        }
      presenter.setToolbarVisibility(toHelloState.toolbarVisibility);
      presenter.setTextVisibility(toHelloState.textVisibility);
        presenter.setBtnClicked(toHelloState.btnSayClicked);
      presenter.setPBVisibility (toHelloState.pbVisibility);

    presenter.onScreenStarted();
  }
    @Override
    public void startingByeScreen(Bye.ToBye presenter){
        if(toByeState != null) {
            toByeState.textVisibility= byeToHelloState.textVisibility;
            toByeState.toolbarVisibility= byeToHelloState.toolbarVisibility;
            toByeState.btnSayClicked= byeToHelloState.btnSayClicked;

            presenter.setToolbarVisibility(toByeState.toolbarVisibility);
            presenter.setTextVisibility(toByeState.textVisibility);
            presenter.setBtnHelloClicked(toByeState.btnSayClicked);
            //presenter.setPBVisibility (toHelloState.pbVisibility);
        }
        presenter.onScreenStarted();
    }

  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToByeScreen(Hello.HelloToBye presenter) {
    byeToHelloState = new ByeState();

    byeToHelloState.toolbarVisibility = presenter.isToolbarVisible();
    byeToHelloState.textVisibility = presenter.isTextVisible();
      byeToHelloState.btnSayClicked =presenter.isBtnSayClicked();

      if (toByeState==null)
    toByeState = new ByeState();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, ByeView.class));
      presenter.destroyView();
    }

  }
  @Override
  public void goToHelloScreen(Bye.ByeToHello presenter) {
    helloToByeState = new HelloState();


    helloToByeState.toolbarVisibility = presenter.isToolbarVisible();
    helloToByeState.textVisibility = presenter.isTextVisible();
      helloToByeState.btnSayClicked=presenter.isBtnByeClicked();


    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, HelloView.class));
      presenter.destroyView();
    }

  }




  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  public class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  public class HelloState {
    boolean toolbarVisibility;
    boolean textVisibility;
      boolean btnSayClicked;
   boolean  pbVisibility;


  }
    public class ByeState {
        boolean toolbarVisibility;
        boolean textVisibility;
        boolean btnSayClicked;
        boolean  pbVisibility;


    }


}
