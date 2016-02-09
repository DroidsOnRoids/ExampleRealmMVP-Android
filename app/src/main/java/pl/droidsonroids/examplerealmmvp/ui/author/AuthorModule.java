package pl.droidsonroids.examplerealmmvp.ui.author;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;
import pl.droidsonroids.examplerealmmvp.ui.publisher.PublisherActivity;

@Module(injects = AuthorActivity.class, addsTo = ApplicationModule.class)
public class AuthorModule {

    private final String mAuthor;

    public AuthorModule(final String author) {
        mAuthor = author;
    }

    @Provides
    AuthorPresenter provideAuthorPresenter(final RealmService realmService) {
        return new AuthorPresenterImpl(realmService, mAuthor);
    }
}
