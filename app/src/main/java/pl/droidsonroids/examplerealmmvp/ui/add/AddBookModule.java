package pl.droidsonroids.examplerealmmvp.ui.add;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

@Module(injects = AddBookActivity.class, addsTo = ApplicationModule.class)
public class AddBookModule {

    @Provides
    AddBookPresenter provideAddBookPresenter(final RealmService realmService) {
        return new AddBookPresenterImpl(realmService);
    }
}
