package es.ulpgc.eite.clean.mvp.dummy.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.dummy.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.dummy.dummy.DummyView;
import es.ulpgc.eite.clean.mvp.dummy.hello.Hello;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private HelloState toHelloState, helloToState;

  @Override
  public void onCreate() {
    super.onCreate();
    toHelloState = new HelloState();
    toHelloState.toolbarVisibility = false;
    toHelloState.textVisibility = false;
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
    if(toHelloState != null) {
      presenter.setToolbarVisibility(toHelloState.toolbarVisibility);
      presenter.setTextVisibility(toHelloState.textVisibility);
      presenter.setPBVisibility (toHelloState.pbVisibility);
    }
    presenter.onScreenStarted();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToNextScreen(Dummy.DummyTo presenter) {
    dummyToState = new DummyState();
    dummyToState.toolbarVisibility = presenter.isToolbarVisible();
    dummyToState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, DummyView.class));
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
    boolean  pbVisibility;


  }


}
