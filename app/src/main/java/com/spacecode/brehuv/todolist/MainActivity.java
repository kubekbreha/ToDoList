package com.spacecode.brehuv.todolist;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.spacecode.brehuv.todolist.fragments.MonthFragment;
import com.spacecode.brehuv.todolist.fragments.NotCompletedFragment;
import com.spacecode.brehuv.todolist.fragments.TodayFragment;
import com.spacecode.brehuv.todolist.fragments.WeekFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button mNavDropdownButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (savedInstanceState == null) {
            TodayFragment loginFragment= new TodayFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_replacable_frame, loginFragment);
            fragmentTransaction.commit();
            Objects.requireNonNull(this.getSupportActionBar()).setTitle(R.string.today);
        }


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //icons white color
        navigationView.setItemIconTintList(null);

        //button in navigation drawer
        View header = navigationView.getHeaderView(0);
        mNavDropdownButton =  header.findViewById(R.id.nav_dropdown_button);
        mNavDropdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, mNavDropdownButton);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.nav_dropdown, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

    }

  
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_today) {
            TodayFragment todayFragment = TodayFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_replacable_frame ,todayFragment)
                    .addToBackStack(null)
                    .commit();
            Objects.requireNonNull(this.getSupportActionBar()).setTitle(R.string.today);

        } else if (id == R.id.nav_this_week) {
            WeekFragment weekFragment = WeekFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_replacable_frame ,weekFragment)
                    .addToBackStack(null)
                    .commit();
            Objects.requireNonNull(this.getSupportActionBar()).setTitle(R.string.this_week);

        } else if (id == R.id.nav_this_month) {
            MonthFragment monthFragment = MonthFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_replacable_frame ,monthFragment)
                    .addToBackStack(null)
                    .commit();
            Objects.requireNonNull(this.getSupportActionBar()).setTitle(R.string.this_month);

        } else if (id == R.id.nav_not_completed) {
            NotCompletedFragment notCompletedFragment = NotCompletedFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_replacable_frame ,notCompletedFragment)
                    .addToBackStack(null)
                    .commit();
            Objects.requireNonNull(this.getSupportActionBar()).setTitle(R.string.not_completed);


        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
