package compsci325.project.recyclegro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.FriendsViewHolder> {
    private List<User> youZer;

    public static class FriendsViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public FriendsViewHolder(@NonNull View recyclerView) {
            super(recyclerView);
            name = (TextView) recyclerView.findViewById(R.id.friend_name);
        }
    }

    public Adapter(List<User> myDataset) {
        youZer = myDataset;
    }

    @NonNull
    @Override
    public Adapter.FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup views, int i) {
        View recyclerView = LayoutInflater.from(views.getContext())
                .inflate(R.layout.friends_card_layout, views, false);
        return new FriendsViewHolder(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder friendsListViewHolder, int position) {
        User person = youZer.get(position);
        friendsListViewHolder.name.setText(person.getFullName());
    }

    @Override
    public int getItemCount() {
        return youZer.size();
    }
}