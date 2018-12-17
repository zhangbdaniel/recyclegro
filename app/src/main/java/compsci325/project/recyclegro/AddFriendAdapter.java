package compsci325.project.recyclegro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.AddFriendViewHolder> {
    private List<User> userList;

    public static class AddFriendViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public Button button;

        public AddFriendViewHolder(@NonNull View recyclerView) {
            super(recyclerView);
            name = (TextView) recyclerView.findViewById(R.id.add_friend_name);
            button = (Button) recyclerView.findViewById(R.id.add_friends_button);
        }
    }

    public AddFriendAdapter(List<User> myDataset) {
        userList = myDataset;
    }

    @NonNull
    @Override
    public AddFriendAdapter.AddFriendViewHolder onCreateViewHolder(@NonNull ViewGroup views, int i) {
        View recyclerView = LayoutInflater.from(views.getContext())
                .inflate(R.layout.add_friends_card_layout, views, false);
        return new AddFriendViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddFriendViewHolder friendsListViewHolder, final int position) {
        final User person = userList.get(position);
        friendsListViewHolder.name.setText(person.getFullName());
        friendsListViewHolder.button.setText("Add Friend");
        friendsListViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList.remove(position);
                Activity activity = ((Activity)v.getContext());
                Toast.makeText(activity, "Friend request to " + person.getFullName() + " has been sent!", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}