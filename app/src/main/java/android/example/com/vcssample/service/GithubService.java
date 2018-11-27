package android.example.com.vcssample.service;

import android.example.com.vcssample.model.GithubUser;
import android.example.com.vcssample.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubService {

    @GET("search/users")
    Call<GithubUsersResponse> getUsers(@Query(value = "q", encoded = true) String query);

    @GET("users/{username}")
    Call<GithubUser> getUser(@Path("username")String username);
}
