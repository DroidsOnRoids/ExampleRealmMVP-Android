package pl.droidsonroids.examplerealmmvp.ui.author;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;
import pl.droidsonroids.examplerealmmvp.ui.publisher.PublisherActivity;

@Module(injects = PublisherActivity.class, addsTo = ApplicationModule.class)
public class AuthorModule {

    private final String mPublisher;

    public AuthorModule(final String publisher) {
        mPublisher = publisher;
    }

    @Provides
    PublisherPresenter providePublisherPresenter(final RealmService realmService) {
        return new PublisherPresenterImpl(realmService, mPublisher);
    }
}
