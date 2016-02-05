package pl.droidsonroids.examplerealmmvp.ui.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.inject.Inject;
import pl.droidsonroids.examplerealmmvp.MyApplication;
import pl.droidsonroids.examplerealmmvp.R;

public class MyListActivity extends AppCompatActivity implements MyListView {

    @Inject MyListPresenter mMyListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication.injectModules(this, new MyListModule());
    }
}
