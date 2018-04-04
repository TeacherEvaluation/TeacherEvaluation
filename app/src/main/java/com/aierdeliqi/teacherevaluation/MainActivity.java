package com.aierdeliqi.teacherevaluation;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , BottomNavigationBar.OnTabSelectedListener{
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton floatingActionButton_increase;
    BottomNavigationBar bottomNavigationBar;

    //main_view
    LinearLayout ll1,ll2,ll3;

    public void find(){
        floatingActionMenu = (FloatingActionMenu)findViewById(R.id.fam);
        floatingActionButton_increase = (FloatingActionButton)findViewById(R.id.fab_1);
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);

        ll1 = (LinearLayout)findViewById(R.id.first_main);
        ll2 = (LinearLayout)findViewById(R.id.second_main);
        ll3 = (LinearLayout)findViewById(R.id.third_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        find();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //bottom navigation bar
        BadgeItem badgeItem = new BadgeItem()
                .setBorderWidth(0)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("2")
                .setHideOnSelect(true);

        BottomNavigationItem item1 = new BottomNavigationItem(R.drawable.ic_menu_camera,"first")
                .setActiveColorResource(R.color.seaLord_start)
                .setBadgeItem(badgeItem);
        BottomNavigationItem item2 = new BottomNavigationItem(R.drawable.ic_menu_gallery,"second")
                .setActiveColorResource(R.color.seaLord_center);
        BottomNavigationItem item3 = new BottomNavigationItem(R.drawable.ic_menu_send,"third")
                .setActiveColorResource(R.color.seaLord_end);

        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.addItem(item1)
                .addItem(item2)
                .addItem(item3)
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void isVisiable(int i){
        if(i == 0){
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.INVISIBLE);
        }else if(i == 1){
            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.INVISIBLE);
        }else{
            ll1.setVisibility(View.INVISIBLE);
            ll2.setVisibility(View.INVISIBLE);
            ll3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onTabSelected(int position) {
        isVisiable(position);
        if (position == 0){

        }
        else if (position == 1){

        }
        else {

        }

    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {
    }
}
