package pl.droidsonroids.examplerealmmvp.ui.books;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

@Module(injects = BooksActivity.class, addsTo = ApplicationModule.class)
public class BooksModule {

    @Provides
    ListPresenter provideMyListPresenter(final RealmService realmService) {
        return new ListPresenterImpl(realmService);
    }
}
