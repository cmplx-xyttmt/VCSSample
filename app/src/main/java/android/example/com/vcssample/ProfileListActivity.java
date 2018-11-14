package android.example.com.vcssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;

public class ProfileListActivity extends AppCompatActivity {
    private final LinkedList<Profile> mProfileList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProfileListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);

        for (int i = 0; i < 20; i++) {
            mProfileList.addLast(new Profile("cmplx-xyttmt" + i, Integer.toString(i)));
        }

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new ProfileListAdapter(this, mProfileList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
