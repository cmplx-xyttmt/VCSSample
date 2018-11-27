package android.example.com.vcssample.presenter;

import android.example.com.vcssample.model.GithubUsersResponse;
import android.example.com.vcssample.service.GithubService;
import android.example.com.vcssample.service.ServiceBuilder;
import android.example.com.vcssample.view.ProfileListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private ProfileListView profileListView;
    private GithubService githubService;

    public GithubPresenter(ProfileListView view) {
        this.profileListView = view;
        githubService = ServiceBuilder.buildService(GithubService.class);
    }

    public void getUsers() {
        final Call<GithubUsersResponse> usersRequest = githubService.getUsers("location:Kenya+language:java");

        usersRequest.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                profileListView.usersReady(response.body().getGithubUsers());
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                profileListView.onResponseFailure(t);
            }
        });
    }
}
