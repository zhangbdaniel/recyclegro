package compsci325.project.recyclegro;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddFriendActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AddFriendAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<User> youZer;
    private List<User> searchList;
    private SearchView searchView;

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
        searchList = new ArrayList<User>();
        adapter = new AddFriendAdapter(youZer);
        manager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.setSearchList(searchList);

        prepareUser();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.add_friends_menu, menu);

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TextView textView = findViewById(R.id.suggested_friends);
                textView.setVisibility(View.GONE);
                searchList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                TextView textView = findViewById(R.id.suggested_friends);
                textView.setVisibility(View.GONE);
                searchList(newText);
                return false;
            }
        });

        AppCompatImageView closeButton = (AppCompatImageView) searchView.findViewById(R.id.search_close_btn);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuItem searchItem= menu.findItem(R.id.search);

                EditText et = (EditText) findViewById(R.id.search_src_text);
                et.setText("");

                searchView.setQuery("", false);
                searchView.onActionViewCollapsed();
                searchItem.collapseActionView();

                resetView();
            }
        });

        return true;
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

        User user4 = new User("Son", "Goku");
        user4.setRecyclePoints(123);
        searchList.add(user4);

        User user5 = new User("Aizen", "Sosuke");
        user5.setRecyclePoints(124);
        searchList.add(user5);

        User user6 = new User("Renji", "Abarai");
        user6.setRecyclePoints(153);
        searchList.add(user6);

        User user7 = new User("Toshiro", "Hitsugaya");
        user7.setRecyclePoints(235);
        searchList.add(user7);

        User user8 = new User("Ichibe", "Hyosube");
        user8.setRecyclePoints(252);
        searchList.add(user8);

        User user9 = new User("Gin", "Ichimaru");
        user9.setRecyclePoints(623);
        searchList.add(user9);

        User user10 = new User("Izuru", "Kira");
        user10.setRecyclePoints(233);
        searchList.add(user10);

        User user11 = new User("Byakuya", "Kuchiki");
        user11.setRecyclePoints(314);
        searchList.add(user11);

        User user12 = new User("Itachi", "Uchiha");
        user12.setRecyclePoints(234);
        searchList.add(user12);

        adapter.notifyDataSetChanged();
    }

    public void searchList(String userInput) {
        List<User> list = new ArrayList<User>();
        if(!userInput.isEmpty()) {
            for (User user : searchList) {
                if (user.getFullName().contains(userInput)) {
                    list.add(user);
                }
            }
            adapter.setUserList(list);
            adapter.notifyDataSetChanged();
        }else{
            resetView();
        }
    }

    private void resetView() {
        TextView textView = findViewById(R.id.suggested_friends);
        textView.setVisibility(View.VISIBLE);
        adapter.setUserList(youZer);
        adapter.notifyDataSetChanged();
    }
}
