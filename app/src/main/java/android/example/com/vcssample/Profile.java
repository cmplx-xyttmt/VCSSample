package android.example.com.vcssample;

public class Profile {
    private final String username;
    private final String profileImage;

    Profile(String username, String profileImage) {
        this.username = username;
        this.profileImage = profileImage;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
