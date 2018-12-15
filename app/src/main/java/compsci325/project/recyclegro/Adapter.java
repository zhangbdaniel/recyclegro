package compsci325.project.recyclegro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<User> youZer;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public MyViewHolder(@NonNull View recyclerView) {
            super(recyclerView);
            name = (TextView) recyclerView.findViewById(R.id.friend_name);
        }
    }
    public Adapter(List<User> myDataset) {
        youZer = myDataset;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup views, int i) {
        View recyclerView = LayoutInflater.from(views.getContext()).inflate(R.layout.recycler_view_item, views, false);
        return new MyViewHolder(recyclerView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder friendsListViewHolder, int position) {
        User person = youZer.get(position);
        friendsListViewHolder.name.setText(person.getFullName());
    }
    @Override
    public int getItemCount() {
        return youZer.size();
    }
}