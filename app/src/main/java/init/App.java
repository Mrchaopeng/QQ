package init;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by TH on 2018/3/8.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
