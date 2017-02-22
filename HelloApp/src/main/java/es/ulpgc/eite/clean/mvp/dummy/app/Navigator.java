package es.ulpgc.eite.clean.mvp.dummy.app;

import es.ulpgc.eite.clean.mvp.dummy.bye.Bye;
import es.ulpgc.eite.clean.mvp.dummy.hello.Hello;

public interface Navigator {
  void goToByeScreen(Hello.HelloToBye presenter);
  void goToHelloScreen(Bye.ByeToHello presenter);
}
