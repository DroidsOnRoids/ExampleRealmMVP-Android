package pl.droidsonroids.examplerealmmvp.model.realm;

import io.realm.Realm;

public class RealmService {

    private final Realm mRealm;

    public RealmService(final Realm realm) {
        mRealm = realm;
    }


}
