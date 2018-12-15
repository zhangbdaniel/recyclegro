package compsci325.project.recyclegro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LeaderBoardAdapter extends
        RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardViewHolder> {
    private List<User> userList;

    public class LeaderBoardViewHolder extends RecyclerView.ViewHolder {
        public TextView username;
        public TextView ranking;
        public TextView points;

        public LeaderBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.leaderboard_username);
            ranking = (TextView) itemView.findViewById(R.id.leaderboard_ranking);
            points = (TextView) itemView.findViewById(R.id.leaderboard_points);
        }
    }

    public LeaderBoardAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public LeaderBoardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.leader_board_card_layout, viewGroup, false);
        return new LeaderBoardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderBoardViewHolder leaderBoardViewHolder, int i) {
        User user = userList.get(i);
        leaderBoardViewHolder.username.setText(user.getFullName());
        leaderBoardViewHolder.ranking.setText("Rank: " + (i+1));
        leaderBoardViewHolder.points.setText("" + user.getRecyclePoints());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
