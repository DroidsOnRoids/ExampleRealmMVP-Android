package pl.droidsonroids.examplerealmmvp;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module(injects = MyApplication.class, library = true)
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(final Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
