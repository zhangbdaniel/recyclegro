package compsci325.project.recyclegro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AddFriendActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AddFriendAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private static List<User> youZer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_add_friends);
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

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_add_friends);
        youZer = new ArrayList<User>();
        adapter = new AddFriendAdapter(youZer);
        manager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareUser();
    }

    private void prepareUser() {
        User user1 = new User("Sasuke", "Uchiha");
        user1.setRecyclePoints(210);
        youZer.add(user1);

        User user2 = new User("Madara", "Uchiha");
        user2.setRecyclePoints(1199);
        youZer.add(user2);

        User user3 = new User("Itachi", "Uchiha");
        user3.setRecyclePoints(1010);
        youZer.add(user3);

        adapter.notifyDataSetChanged();
    }
}
