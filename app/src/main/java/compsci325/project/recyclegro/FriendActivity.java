package compsci325.project.recyclegro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class FriendActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<User> youZer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new Adapter(youZer);
        recyclerView.setAdapter(adapter);
    }

    private void prepareUser() {
        User user1 = new User("Thomas", "Hubbard");
        user1.setRecyclePoints(1235);
        youZer.add(user1);

        User user2 = new User("Darren", "Farrelly");
        user2.setRecyclePoints(1122);
        youZer.add(user2);

        User user3 = new User("Gaurab", "Pant");
        user3.setRecyclePoints(930);
        youZer.add(user3);

        User user4 = new User("Daniel", "Zhang");
        user4.setRecyclePoints(837);
        youZer.add(user4);

        User user5 = new User("Naruto", "Uzumaki");
        user5.setRecyclePoints(639);
        youZer.add(user5);

        User user6 = new User("Ichigo", "Kurosaki");
        user6.setRecyclePoints(523);
        youZer.add(user6);

        User user7 = new User("Luffy", "Monkey");
        user7.setRecyclePoints(453);
        youZer.add(user7);

        User user8 = new User("Izuku", "Midoriya");
        user8.setRecyclePoints(445);
        youZer.add(user8);

        User user9 = new User("Asta", "");
        user9.setRecyclePoints(340);
        youZer.add(user9);

        adapter.notifyDataSetChanged();
    }
}
