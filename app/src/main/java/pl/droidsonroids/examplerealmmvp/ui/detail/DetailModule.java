package pl.droidsonroids.examplerealmmvp.ui.detail;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

@Module(injects = DetailActivity.class, addsTo = ApplicationModule.class)
public class DetailModule {

    private final int mBookId;

    public DetailModule(final int bookId) {
        mBookId = bookId;
    }

    @Provides
    DetailPresenter provideMyDetailPresenter(final RealmService realmService) {
        return new DetailPresenterImpl(realmService, mBookId);
    }
}
