package pl.droidsonroids.examplerealmmvp;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import pl.droidsonroids.examplerealmmvp.model.realm.RealmService;

@Module(injects = BooksApplication.class, library = true)
public class ApplicationModule {

    public ApplicationModule() {}

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    RealmService provideRealmService(final Realm realm) {
        return new RealmService(realm);
    }
}
