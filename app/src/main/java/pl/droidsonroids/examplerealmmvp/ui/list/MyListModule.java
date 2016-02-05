package pl.droidsonroids.examplerealmmvp.ui.list;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;

@Module(injects = MyListActivity.class, addsTo = ApplicationModule.class)
public class MyListModule {

    @Provides
    MyListPresenter provideMyListPresenter() {
        return new MyListPresetnterImpl();
    }
}
