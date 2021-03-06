package es.ulpgc.eite.clean.mvp.dummy.bye;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.dummy.R;

public class ByeView
    extends GenericActivity<Bye.PresenterToView, Bye.ViewToPresenter, ByePresenter>
    implements Bye.PresenterToView {

  private Toolbar toolbar;
  private Button buttonSay;
  private Button buttonGoTo;
  private TextView text;
  //private ProgressBar bar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bye);

    //bar= (ProgressBar) findViewById(R.id.progressBar);

    text = (TextView) findViewById(R.id.text);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    buttonSay = (Button) findViewById(R.id.button1);
    buttonSay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().onButtonSayClicked();
      }
    });

    buttonGoTo = (Button) findViewById(R.id.button2);
    buttonGoTo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().onButtonGoToClicked();
      }
    });
  }

  /**
   * Method that initialized MVP objects
   * {@link super#onResume(Class, Object)} should always be called
   */
  @Override
  protected void onResume() {
    super.onResume(ByePresenter.class, this);
  }

  /*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_bye, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up buttonSay, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  */


  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To View /////////////////////////////////////////////////////////////

  @Override
  public void finishScreen() {
    finish();
  }

  @Override
  public void hideToolbar() {
    toolbar.setVisibility(View.GONE);
  }

  @Override
  public void hideText() {
    text.setVisibility(View.GONE);
  }

  @Override
  public void showText() {
    text.setVisibility(View.VISIBLE);
  }

  @Override
  public void setText(String txt) {
    text.setText(txt);
  }

  @Override
  public void setLabel(String txt) {
    buttonSay.setText(txt);
  }

  @Override
  public void setLabel2(String txt) {
    buttonGoTo.setText(txt);
  }

 /* @Override
  public void showPB(){
    bar.setVisibility(View.VISIBLE);
    for (int i=0; i<1000000000; i++);
    hidePB();
  }

  @Override
  public void hidePB() {
    bar.setVisibility(View.GONE);


  }*/
}
