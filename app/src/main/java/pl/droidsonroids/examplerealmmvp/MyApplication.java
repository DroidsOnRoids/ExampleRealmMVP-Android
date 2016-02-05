package pl.droidsonroids.examplerealmmvp;

import android.app.Application;
import android.support.annotation.NonNull;
import dagger.ObjectGraph;

public class MyApplication extends Application {

    private static MyApplication sInstance;
    private ObjectGraph mApplicationGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        initApplicationGraph();
    }

    private void initApplicationGraph() {
        mApplicationGraph = ObjectGraph.create(new ApplicationModule(this));
    }

    public static void injectModules(@NonNull final Object object, final Object... modules) {
        sInstance.mApplicationGraph.plus(modules).inject(object);
    }
}
