package compsci325.project.recyclegro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    private List<User> userList;
    private LeaderBoardAdapter leaderBoardAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_leaderboard);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        recyclerView = (RecyclerView) findViewById(R.id.leaderboard_main_layout);
        userList = new ArrayList<User>();
        leaderBoardAdapter = new LeaderBoardAdapter(userList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(leaderBoardAdapter);

        prepareUser();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.leaderboard_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu_leaderboards) {
        Intent goToFriends = new Intent(this, FriendActivity.class);
        startActivity(goToFriends);
        return false;
    }

    private void prepareUser() {
        User user1 = new User("Thomas", "Hubbard");
        user1.setRecyclePoints(1235);
        userList.add(user1);

        User user2 = new User("Darren", "Farrelly");
        user2.setRecyclePoints(1122);
        userList.add(user2);

        User user3 = new User("Gaurab", "Pant");
        user3.setRecyclePoints(930);
        userList.add(user3);

        User user4 = new User("Daniel", "Zhang");
        user4.setRecyclePoints(837);
        userList.add(user4);

        User user5 = new User("Naruto", "Uzumaki");
        user5.setRecyclePoints(639);
        userList.add(user5);

        User user6 = new User("Ichigo", "Kurosaki");
        user6.setRecyclePoints(523);
        userList.add(user6);

        User user7 = new User("Luffy", "Monkey");
        user7.setRecyclePoints(453);
        userList.add(user7);

        User user8 = new User("Izuku", "Midoriya");
        user8.setRecyclePoints(445);
        userList.add(user8);

        User user9 = new User("Asta", "");
        user9.setRecyclePoints(340);
        userList.add(user9);

        leaderBoardAdapter.notifyDataSetChanged();
    }
}
