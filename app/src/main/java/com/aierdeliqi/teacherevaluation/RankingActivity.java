package com.aierdeliqi.teacherevaluation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RankingActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener {
    private int position;
    private String teachername;
    Spinner sp_prefer, rank_1_digit, rank_2_digit, rank_3_digit, rank_4_digit,
            rank_1_language, rank_2_language, rank_3_language, rank_4_language,
            rank_1_martrix, rank_2_martrix, rank_3_martrix, rank_4_martrix;
    RatingBar rank_1_star, rank_2_star, rank_3_star, rank_4_star;
    TextView tv_ranktechername;

    private void find() {
        sp_prefer = findViewById(R.id.sp_prefer);
        rank_1_digit = findViewById(R.id.rank_1_digit);
        rank_2_digit = findViewById(R.id.rank_2_digit);
        rank_3_digit = findViewById(R.id.rank_3_digit);
        rank_4_digit = findViewById(R.id.rank_4_digit);
        rank_1_language = findViewById(R.id.rank_1_language);
        rank_2_language = findViewById(R.id.rank_2_language);
        rank_3_language = findViewById(R.id.rank_3_language);
        rank_4_language = findViewById(R.id.rank_4_language);
        rank_1_martrix = findViewById(R.id.rank_1_martrix);
        rank_2_martrix = findViewById(R.id.rank_2_martrix);
        rank_3_martrix = findViewById(R.id.rank_3_martrix);
        rank_4_martrix = findViewById(R.id.rank_4_martrix);
        rank_1_star = findViewById(R.id.rank_1_star);
        rank_2_star = findViewById(R.id.rank_2_star);
        rank_3_star = findViewById(R.id.rank_3_star);
        rank_4_star = findViewById(R.id.rank_4_star);
        tv_ranktechername = findViewById(R.id.rank_teachername);
    }

    private void setListener() {
        sp_prefer.setOnItemSelectedListener(this);
        rank_1_digit.setOnItemSelectedListener(this);
        rank_2_digit.setOnItemSelectedListener(this);
        rank_3_digit.setOnItemSelectedListener(this);
        rank_4_digit.setOnItemSelectedListener(this);
        rank_1_language.setOnItemSelectedListener(this);
        rank_2_language.setOnItemSelectedListener(this);
        rank_3_language.setOnItemSelectedListener(this);
        rank_4_language.setOnItemSelectedListener(this);
        rank_1_martrix.setOnItemSelectedListener(this);
        rank_2_martrix.setOnItemSelectedListener(this);
        rank_3_martrix.setOnItemSelectedListener(this);
        rank_4_martrix.setOnItemSelectedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        find();
        setListener();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        teachername = intent.getStringExtra("name");
        tv_ranktechername.setText(teachername);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "确定保存？", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rankingmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_submit) {
            setResult(1);
            finish();
            Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("是否退出？")
                .setMessage("退出将会丢失未保存的数据。点击取消进行保存或点击退出继续退出。")
                .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setCancelable(false)
                .create();
        builder.show();
    }

    private void allGone() {
        rank_1_digit.setVisibility(View.GONE);
        rank_2_digit.setVisibility(View.GONE);
        rank_3_digit.setVisibility(View.GONE);
        rank_4_digit.setVisibility(View.GONE);
        rank_1_language.setVisibility(View.GONE);
        rank_2_language.setVisibility(View.GONE);
        rank_3_language.setVisibility(View.GONE);
        rank_4_language.setVisibility(View.GONE);
        rank_1_martrix.setVisibility(View.GONE);
        rank_2_martrix.setVisibility(View.GONE);
        rank_3_martrix.setVisibility(View.GONE);
        rank_4_martrix.setVisibility(View.GONE);
        rank_1_star.setVisibility(View.GONE);
        rank_2_star.setVisibility(View.GONE);
        rank_3_star.setVisibility(View.GONE);
        rank_4_star.setVisibility(View.GONE);
    }

    private void changePrefer(int i) {
        allGone();
        switch (i){
            case 0:
                rank_1_digit.setVisibility(View.VISIBLE);
                rank_2_digit.setVisibility(View.VISIBLE);
                rank_3_digit.setVisibility(View.VISIBLE);
                rank_4_digit.setVisibility(View.VISIBLE);
                break;
            case 1:
                rank_1_language.setVisibility(View.VISIBLE);
                rank_2_language.setVisibility(View.VISIBLE);
                rank_3_language.setVisibility(View.VISIBLE);
                rank_4_language.setVisibility(View.VISIBLE);
                break;
            case 2:
                rank_1_martrix.setVisibility(View.VISIBLE);
                rank_2_martrix.setVisibility(View.VISIBLE);
                rank_3_martrix.setVisibility(View.VISIBLE);
                rank_4_martrix.setVisibility(View.VISIBLE);
                break;
            case 3:
                rank_1_star.setVisibility(View.VISIBLE);
                rank_2_star.setVisibility(View.VISIBLE);
                rank_3_star.setVisibility(View.VISIBLE);
                rank_4_star.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == sp_prefer) {
            changePrefer(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
