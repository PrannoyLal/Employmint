package thacks.employmint;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class jobsearch extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView title, prompt, sidebartitle;
    ImageView kumon, tims, wealth, target;
    ImageButton find;
    EditText search;
    Animation fadein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobsearch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Typeface customfont=Typeface.createFromAsset(getAssets(),"fonts/arca.otf");
        title=(TextView)findViewById(R.id.title);
        title.setTypeface(customfont);

        prompt=(TextView)findViewById(R.id.prompt);
       // prompt.setTypeface(customfont);

        sidebartitle=(TextView)findViewById(R.id.sidebartitle);
      //  sidebartitle.setTypeface(customfont);

        kumon=(ImageView)findViewById(R.id.kumon);
        tims=(ImageView)findViewById(R.id.tims);
        wealth=(ImageView)findViewById(R.id.wealth);
        target=(ImageView)findViewById(R.id.target);

        search=(EditText)findViewById(R.id.searchfield);

        fadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeprompt);

        find=(ImageButton)findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!search.getText().toString().equals("") && !search.getText().toString().equals(null))
                    initSearch();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jobsearch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            switchScreens();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_resume) {
            // Handle the camera action
        } else if (id == R.id.nav_savedjobs) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_feedback) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchScreens(){
        Intent intent=new Intent (jobsearch.this, homeLogin.class);
        startActivity(intent);
    }

    private void initSearch(){
        CountDownTimer artificaldelay=new CountDownTimer(2200,1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                kumon.setVisibility(View.VISIBLE);
                wealth.setVisibility(View.VISIBLE);
                target.setVisibility(View.VISIBLE);
                tims.setVisibility(View.VISIBLE);

                kumon.startAnimation(fadein);
                wealth.startAnimation(fadein);
                target.startAnimation(fadein);
                tims.startAnimation(fadein);
            }
        };
        artificaldelay.start();
    }
}
