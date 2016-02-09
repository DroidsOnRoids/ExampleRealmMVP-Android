package pl.droidsonroids.examplerealmmvp.ui.publisher;

import dagger.Module;
import dagger.Provides;
import pl.droidsonroids.examplerealmmvp.ApplicationModule;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

@Module(injects = PublisherActivity.class, addsTo = ApplicationModule.class)
public class PublisherModule {

    private final String mPublisher;

    public PublisherModule(final String publisher) {
        mPublisher = publisher;
    }

    @Provides
    PublisherPresenter providePublisherPresenter(final RealmService realmService) {
        return new PublisherPresenterImpl(realmService, mPublisher);
    }
}
