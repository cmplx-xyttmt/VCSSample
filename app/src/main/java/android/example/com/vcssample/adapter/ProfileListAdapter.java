package android.example.com.vcssample.adapter;

import android.content.Context;
import android.example.com.vcssample.R;
import android.example.com.vcssample.model.GithubUser;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ProfileViewHolder> {
    private final ArrayList<GithubUser> mProfileList;
    private LayoutInflater mInflater;


    public ProfileListAdapter(Context context, List<GithubUser> profileList) {
        mInflater = LayoutInflater.from(context);
        mProfileList = (ArrayList<GithubUser>) profileList;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mProfileView = mInflater.inflate(R.layout.profilelist_item, parent, false);
        return new ProfileViewHolder((LinearLayout) mProfileView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        GithubUser profile = mProfileList.get(position);
        Picasso.get().load(profile.getAvatarUrl()).into(holder.mProfileImage);
        holder.mProfileUsername.setText(profile.getUsername());
    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {
        final ImageView mProfileImage;
        final TextView mProfileUsername;
        final ProfileListAdapter mAdapter;

        ProfileViewHolder(LinearLayout mProfileItemView, ProfileListAdapter adapter) {
            super(mProfileItemView);
            mProfileImage = mProfileItemView.findViewById(R.id.list_profile_image);
            mProfileUsername = mProfileItemView.findViewById(R.id.list_username);
            mAdapter = adapter;
        }
    }
}
