package android.example.com.vcssample.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {

    @SerializedName("items")
    private List<GithubUser> githubUsers;

    public GithubUsersResponse() {
        githubUsers = new ArrayList<>();
    }

    public List<GithubUser> getGithubUsers() {
        return githubUsers;
    }
}
