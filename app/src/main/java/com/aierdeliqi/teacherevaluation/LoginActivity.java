package com.aierdeliqi.teacherevaluation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.Button;

public class LoginActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener, View.OnClickListener {
    Spinner sp_account;
    ImageButton ib_logo;
    CardView cardView,card_login;
    TextView tv_rebuild;
    LinearLayout ll_sp;
    EditText et_account, et_password;
    boolean state = true;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Context context = getApplicationContext();
        findView();
        sp_account.setOnItemSelectedListener(this);
        tv_rebuild.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == sp_account) {
            if (position == 0) {
                ib_logo.setBackground(getDrawable(R.drawable.logo));
            } else {
                ib_logo.setBackground(getDrawable(R.drawable.logo2));
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_rebuild) {
            obanime();
            ll_sp.setVisibility(View.GONE);
            et_account.setHint("修改密码:");
            et_password.setHint("再次输入密码:");
            tv_rebuild.setVisibility(View.INVISIBLE);
            btn_login.setText("确认");
            state = !state;
        }
        else if (v.getId() == R.id.btn_login){
            if (!state) {
                obanime();
                ll_sp.setVisibility(View.VISIBLE);
                et_account.setHint("账号:");
                et_password.setHint("密码:");
                btn_login.setText("登陆");
                tv_rebuild.setVisibility(View.VISIBLE);
                state = !state;
            }else {
                String account = et_account.getText()+"";
                if (account.equals("")){
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }












    //extra
    private void findView() {
        sp_account = findViewById(R.id.sp_accountstyle);
        ib_logo = findViewById(R.id.ib_logo);
        cardView = findViewById(R.id.card_1);
        tv_rebuild = findViewById(R.id.tv_rebuild);
        ll_sp = findViewById(R.id.sp_layout);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        card_login = findViewById(R.id.card_login);
    }
    private void obanime(){
        ObjectAnimator ob = ObjectAnimator.ofFloat(cardView, "translationX", 0, -1000).setDuration(500);
        ob.setInterpolator(new OvershootInterpolator());
        ob.start();
        ObjectAnimator ob2 = ObjectAnimator.ofFloat(ib_logo, "translationY", 0, -50,0).setDuration(500);
        ob2.setInterpolator(new DecelerateInterpolator());
        ob2.start();
        ob = ObjectAnimator.ofFloat(cardView, "translationX", 1000, 0).setDuration(500);
        ob.setInterpolator(new OvershootInterpolator());
        ob.setStartDelay(300);
        ob.start();
        ObjectAnimator ob3 = ObjectAnimator.ofFloat(card_login, "scaleX", 1, 0.5f,1).setDuration(800);
        ob3.setInterpolator(new OvershootInterpolator());
        ob3.start();
    }
}
