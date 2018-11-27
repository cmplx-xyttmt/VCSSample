package android.example.com.vcssample.view;

import android.example.com.vcssample.adapter.ProfileListAdapter;
import android.example.com.vcssample.R;
import android.example.com.vcssample.model.GithubUser;
import android.example.com.vcssample.presenter.GithubPresenter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;


public class ProfileListActivity extends AppCompatActivity implements ProfileListView {
    public static final String LIST_STATE_KEY = "users_list_state";
//    public static final String LIST_ACTIVITY_TAG = "ProfileListActivity";
    Parcelable githubUsersListState;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);

        mLayoutManager = new LinearLayoutManager(this);
        GithubPresenter presenter = new GithubPresenter(this);
        presenter.getUsers();
    }

    @Override
    public void usersReady(List<GithubUser> githubUsers) {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new ProfileListAdapter(this, githubUsers));
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this,
                "Something went wrong: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        githubUsersListState = mLayoutManager.onSaveInstanceState();
        outState.putParcelable(LIST_STATE_KEY, githubUsersListState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            githubUsersListState = savedInstanceState.getParcelable(LIST_STATE_KEY);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (githubUsersListState != null) {
            mLayoutManager.onRestoreInstanceState(githubUsersListState);
        }
    }
}
