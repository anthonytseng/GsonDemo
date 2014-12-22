package andyang.tw.gsondemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by andyang on 14/12/22.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        findViewById();
        setView();
        setListener();
        doExtra();
    }

    protected abstract int getLayoutId();

    protected abstract void findViewById();

    protected abstract void setView();

    protected abstract void setListener();

    protected abstract void doExtra();

}
