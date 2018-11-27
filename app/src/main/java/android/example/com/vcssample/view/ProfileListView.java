package android.example.com.vcssample.view;

import android.example.com.vcssample.model.GithubUser;

import java.util.List;

public interface ProfileListView {

    void usersReady(List<GithubUser> githubUsers);

    void onResponseFailure(Throwable throwable);
}
