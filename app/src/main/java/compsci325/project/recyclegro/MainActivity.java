package compsci325.project.recyclegro;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationIcon(R.drawable.ic_people_outline_black_24dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //<--- link to friends page goes here ---->
                    }
                }
        );
        //if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable() == SUCCESS))
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.example_menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu_leaderboards) {
        //<---- leaderboards code goes here ------->
        return true;
    }
}
