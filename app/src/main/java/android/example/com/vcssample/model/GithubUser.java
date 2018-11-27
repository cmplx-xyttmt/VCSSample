package android.example.com.vcssample.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class GithubUser implements Parcelable {

    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("url")
    private String url;

    @SerializedName("name")
    private String name;

    public String getUsername() {
        return username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "{"
                + "\nusername: " + username
                + "\navatarUrl: " + avatarUrl
                + "\nurl: " + url
                + "\nname: " + name
                + "\n}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(avatarUrl);
        dest.writeString(url);
        dest.writeString(name);
    }

    public static final Parcelable.Creator<GithubUser> CREATOR
            = new Parcelable.Creator<GithubUser>() {
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

    private GithubUser(Parcel in) {
        username = in.readString();
        avatarUrl = in.readString();
        url = in.readString();
        name = in.readString();
    }
}
