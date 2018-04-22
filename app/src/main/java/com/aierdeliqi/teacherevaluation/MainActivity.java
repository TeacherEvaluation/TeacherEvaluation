package com.aierdeliqi.teacherevaluation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aierdeliqi.teacherevaluation.mAdapter.Coruse;
import com.aierdeliqi.teacherevaluation.mAdapter.CourseAdapter;
import com.aierdeliqi.teacherevaluation.mAdapter.Ranking;
import com.aierdeliqi.teacherevaluation.mAdapter.RankingAdapter;
import com.aierdeliqi.teacherevaluation.mAdapter.TalkAdapter;
import com.aierdeliqi.teacherevaluation.mAdapter.Talks;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.youth.banner.Banner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationBar.OnTabSelectedListener,
        FloatingActionButton.OnClickListener,
        AdapterView.OnItemClickListener{
    FloatingActionMenu fm;
    FloatingActionButton fb_1, fb_2, fb_3;
    BottomNavigationBar bottomNavigationBar;
    Banner banner;
    SwipeRefreshLayout swipeRefresh, swipeRefresh2, swipeRefresh3;

    String[] name1 = new String[]{"学生1", "学生2", "学生3", "学生4", "学生3", "学生3", "学生3", "学生3", "学生3"};
    String[] teacher = new String[]{"教师1", "教师2", "教师3", "教师4", "教师2", "教师2", "教师2", "教师2", "教师2"};
    String[] times = new String[]{"10分钟前", "12分钟前", "13分钟前", "20分钟前", "20分钟前", "20分钟前", "20分钟前", "20分钟前", "20分钟前"};
    String[] teacherName = new String[]{"赵老师", "钱老师", "孙老师", "李老师", "周老师", "吴老师", "郑老师", "王老师"};
    String[] courseName = new String[]{"高数", "英语", "大物", "程序设计", "数据结构", "数据库", "网络原理", "软件管理"};
    String[] rankscore = new String[]{"9.8", "8.7", "8.2", "8.1", "7.6", "7.5", "6", "5.4"};

    //main_view
    LinearLayout ll1, ll2, ll3;

    ListView lv, lv_course, lv_search;
    private LinkedList<Talks> mDataNews = null;
    private LinkedList<Coruse> mDataCourse = null;
    private LinkedList<Ranking> mDataRank = null;
    private Context context;
    private TalkAdapter talkAdapter = null;
    private CourseAdapter courseAdapter = null;
    private RankingAdapter rankingAdapter = null;

    TextView info_name, info_sex, info_age, info_zhuanye, info_classes, info_num;

    private final static int REQUEST = 1;
    private static int lPosition;

    public void find() {
        fm = findViewById(R.id.fam);
        fb_1 = findViewById(R.id.fab_1);
        fb_2 = findViewById(R.id.fab_2);
        fb_3 = findViewById(R.id.fab_3);
        fm.setClosedOnTouchOutside(true);
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        ll1 = findViewById(R.id.first_main);
        ll2 = findViewById(R.id.second_main);
        ll3 = findViewById(R.id.third_main);

        lv = findViewById(R.id.lv);
        lv_course = findViewById(R.id.lv_coruse);
        lv_search = findViewById(R.id.lv_search);

//        View view = getLayoutInflater().inflate(R.layout.first_header, null);
//        banner = view.findViewById(R.id.banner);
//        banner = findViewById(R.id.banner);
        swipeRefresh = findViewById(R.id.swiptorefresh);
        swipeRefresh2 = findViewById(R.id.swiptorefresh_2);
        swipeRefresh3 = findViewById(R.id.swipe_search);

        View view = getLayoutInflater().inflate(R.layout.second_header, null);
        info_age = view.findViewById(R.id.info_age);
        info_classes = view.findViewById(R.id.info_classes);
        info_name = view.findViewById(R.id.info_name);
        info_sex = view.findViewById(R.id.info_sex);
        info_zhuanye = view.findViewById(R.id.info_zhuanye);
        info_num = view.findViewById(R.id.info_num);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        find();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //bottom navigation bar
        BadgeItem badgeItem = new BadgeItem()
                .setBorderWidth(0)
                .setBackgroundColorResource(R.color.colorAccent)
                .setText("2")
                .setHideOnSelect(true);

        BottomNavigationItem item1 = new BottomNavigationItem(R.drawable.ic_nav_first, "消息")
                .setActiveColorResource(R.color.seaLord_start);
//                .setBadgeItem(badgeItem);
        BottomNavigationItem item2 = new BottomNavigationItem(R.drawable.ic_nav_second, "评价")
                .setActiveColorResource(R.color.seaLord_center);
        BottomNavigationItem item3 = new BottomNavigationItem(R.drawable.ic_nav_third, "排名")
                .setActiveColorResource(R.color.seaLord_end);

        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.addItem(item1)
                .addItem(item2)
                .addItem(item3)
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

//        First页开始
        //news
        context = MainActivity.this;
        //加载头部
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headViewNews = inflater.inflate(R.layout.first_header, null, false);
        lv.addHeaderView(headViewNews);
        //轮播图
        banner = headViewNews.findViewById(R.id.banner);
        Integer[] images = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
        banner.setImages(Arrays.asList(images))
                .setImageLoader(new GlideImageLoader())
                .setDelayTime(4000)
                .start();
        //加载链表
        mDataNews = new LinkedList<>();
        for (int i = 0; i < name1.length; i++) {
            mDataNews.add(new Talks(name1[i], teacher[i], times[i]));
        }
        talkAdapter = new TalkAdapter(mDataNews, context);

        //载入布局

        lv.setAdapter(talkAdapter);

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "News刷新完成", Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        lv.setOnItemClickListener(this);
//        First页结束


//        Second页开始
        mDataCourse = new LinkedList<>();
        for (int i = 0; i < teacherName.length; i++) {
            mDataCourse.add(new Coruse(courseName[i], teacherName[i]));
        }
        courseAdapter = new CourseAdapter(mDataCourse, context);
        View headViewCourse = inflater.inflate(R.layout.second_header, null, false);
        info_age = headViewCourse.findViewById(R.id.info_age);
        info_classes = headViewCourse.findViewById(R.id.info_classes);
        info_name = headViewCourse.findViewById(R.id.info_name);
        info_sex = headViewCourse.findViewById(R.id.info_sex);
        info_zhuanye = headViewCourse.findViewById(R.id.info_zhuanye);
        info_num = headViewCourse.findViewById(R.id.info_num);
        lv_course.addHeaderView(headViewCourse);
        lv_course.setAdapter(courseAdapter);

        swipeRefresh2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "评价信息刷新完成", Toast.LENGTH_SHORT).show();
                        swipeRefresh2.setRefreshing(false);
                    }
                }, 2000);
            }
        });

//        lv_course.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
//            }
//        });
        lv_course.setOnItemClickListener(this);
//        Second页结束

//        Third页开始
        mDataRank = new LinkedList<>();
        for (int i = 0;i<teacherName.length;i++){
            mDataRank.add(new Ranking(teacherName[i],rankscore[i]));
        }
        rankingAdapter = new RankingAdapter(mDataRank,context);
        lv_search.setAdapter(rankingAdapter);
//        Third页结束

        //浮动按钮
        fb_1.setOnClickListener(this);
        fb_2.setOnClickListener(this);
        fb_3.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

    //侧边Drawer
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

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //切换页面视图
    public void inVisiable() {
        ll1.setVisibility(View.INVISIBLE);
        ll2.setVisibility(View.INVISIBLE);
        ll3.setVisibility(View.INVISIBLE);
    }

    //页面出现效果
    public void isVisiable(int i) {
        if (i == 0) {
            inVisiable();
            ll1.setVisibility(View.VISIBLE);
            fm.setMenuButtonColorNormalResId(R.color.seaLord_start);
            fb_1.setColorNormalResId(R.color.seaLord_start);
            fb_2.setColorNormalResId(R.color.seaLord_start);
            fb_3.setColorNormalResId(R.color.seaLord_start);
        } else if (i == 1) {
            inVisiable();
            ll2.setVisibility(View.VISIBLE);
            fm.setMenuButtonColorNormalResId(R.color.seaLord_center);
            fb_1.setColorNormalResId(R.color.seaLord_center);
            fb_2.setColorNormalResId(R.color.seaLord_center);
            fb_3.setColorNormalResId(R.color.seaLord_center);
        } else {
            inVisiable();
            ll3.setVisibility(View.VISIBLE);
            fm.setMenuButtonColorNormalResId(R.color.seaLord_end);
            fb_1.setColorNormalResId(R.color.seaLord_end);
            fb_2.setColorNormalResId(R.color.seaLord_end);
            fb_3.setColorNormalResId(R.color.seaLord_end);
        }
    }

    //FloatingMenu&Button动画
    public void showAnime(View view) {
        ObjectAnimator firstShow, secondShow, fmShow, fm2Show;
        firstShow = ObjectAnimator.ofFloat(view, "translationY", 100, 0).setDuration(500);
        secondShow = ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(500);
        fmShow = ObjectAnimator.ofFloat(fm, "translationY", 100, 0).setDuration(500);
        fm2Show = ObjectAnimator.ofFloat(fm, "alpha", 0, 1).setDuration(500);
        fmShow.setInterpolator(new OvershootInterpolator());
        firstShow.setInterpolator(new DecelerateInterpolator(2f));
        firstShow.start();
        secondShow.start();
        fm2Show.start();
        fmShow.start();
    }

    //信息展示动画
    public void infoAnime(View view) {
        Random random = new Random();
        int rand = random.nextInt(900) + 400;
        ObjectAnimator animator, animator1;
        animator = ObjectAnimator.ofFloat(view, "scaleX", 0.2f, 1).setDuration(rand);
        animator1 = ObjectAnimator.ofFloat(view, "scaleY", 0.2f, 1).setDuration(rand);
        animator.setInterpolator(new DecelerateInterpolator(2f));
        animator1.setInterpolator(new DecelerateInterpolator(2f));
        animator.start();
        animator1.start();
    }

    //BottomNavigation切换
    @Override
    public void onTabSelected(int position) {
        isVisiable(position);
        if (position == 0) {
            showAnime(ll1);
        } else if (position == 1) {
            showAnime(ll2);
            infoAnime(info_name);
            infoAnime(info_sex);
            infoAnime(info_age);
            infoAnime(info_zhuanye);
            infoAnime(info_classes);
            infoAnime(info_num);
        } else {
            showAnime(ll3);
        }

    }

    @Override
    public void onTabUnselected(int position) {
    }

    @Override
    public void onTabReselected(int position) {
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, view.getId() + "", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.fab_1:
                infoAnime(info_name);
                infoAnime(info_sex);
                infoAnime(info_age);
                infoAnime(info_zhuanye);
                infoAnime(info_classes);
                infoAnime(info_num);
                fm.close(true);
                break;
            case R.id.fab_2:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.fab_3:

                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
        lPosition = position-1;
        if (parent == lv_course){
            Intent intent = new Intent(MainActivity.this,RankingActivity.class);
            intent.putExtra("position",lPosition);
            intent.putExtra("name",teacherName[lPosition]);
            startActivityForResult(intent,REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){
            if (requestCode == REQUEST){
                //已完成评分
                Toast.makeText(this, "已提交", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "以保存，等待提交", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
