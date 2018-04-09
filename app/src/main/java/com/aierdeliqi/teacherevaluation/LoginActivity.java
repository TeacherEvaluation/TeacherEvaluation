package com.aierdeliqi.teacherevaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_account,et_password,et_account_regist,et_password_regist,et_password_reinput;
    Button btn_login,btn_noaccount,btn_regist;
    TextView tv_title_login,tv_title_regist;


    private void findView(){
        et_account =  findViewById(R.id.et_account);
        et_password =  findViewById(R.id.et_password);
        et_account_regist =  findViewById(R.id.et_account_regist);
        et_password_regist =  findViewById(R.id.et_password_regist);
        et_password_reinput =  findViewById(R.id.et_password_reinput);
        btn_login =  findViewById(R.id.btn_login);
        btn_noaccount =  findViewById(R.id.btn_noaccount);
        btn_regist =  findViewById(R.id.btn_regist);
        tv_title_login =  findViewById(R.id.tv_title_login);
        tv_title_regist =  findViewById(R.id.tv_title_regist);
    }

    //    设置登录页面是否可见
    private void setLoginVisiable(boolean type){
        if(type) {
            tv_title_login.setVisibility(View.VISIBLE);
            et_account.setVisibility(View.VISIBLE);
            et_password.setVisibility(View.VISIBLE);
            btn_login.setVisibility(View.VISIBLE);
            btn_noaccount.setVisibility(View.VISIBLE);
        }
        else{
            tv_title_login.setVisibility(View.INVISIBLE);
            et_account.setVisibility(View.INVISIBLE);
            et_password.setVisibility(View.INVISIBLE);
            btn_login.setVisibility(View.INVISIBLE);
            btn_noaccount.setVisibility(View.INVISIBLE);
        }
    }

    //    设置登录页面是否可见
    private void setRegistVisiable(boolean type){
        if(type) {
            tv_title_regist.setVisibility(View.VISIBLE);
            et_account_regist.setVisibility(View.VISIBLE);
            et_password_regist.setVisibility(View.VISIBLE);
            et_password_reinput.setVisibility(View.VISIBLE);
            btn_regist.setVisibility(View.VISIBLE);
        }
        else{
            tv_title_regist.setVisibility(View.INVISIBLE);
            et_account_regist.setVisibility(View.INVISIBLE);
            et_password_regist.setVisibility(View.INVISIBLE);
            et_password_reinput.setVisibility(View.INVISIBLE);
            btn_regist.setVisibility(View.INVISIBLE);
        }
    }


    //    登录页面动画，true为出现，false为消失
    private void animator_Login(boolean type){
        if (type){
            ObjectAnimator animator_title = ObjectAnimator.ofFloat(tv_title_login,"translationY",2000f,0f).setDuration(1000);
            animator_title.setInterpolator(new DecelerateInterpolator(2f));
            ObjectAnimator animator_account = ObjectAnimator.ofFloat(et_account,"translationY",2000f,0f).setDuration(1000);
            animator_account.setInterpolator(new DecelerateInterpolator(1.8f));
            ObjectAnimator animator_password = ObjectAnimator.ofFloat(et_password,"translationY",2000f,0f).setDuration(1000);
            animator_password.setInterpolator(new DecelerateInterpolator(1.6f));
            ObjectAnimator animator_login = ObjectAnimator.ofFloat(btn_login,"translationY",2000f,0f).setDuration(1000);
            animator_login.setInterpolator(new DecelerateInterpolator(1.4f));
            ObjectAnimator animator_noaccount = ObjectAnimator.ofFloat(btn_noaccount,"translationY",2000f,0f).setDuration(1000);
            animator_noaccount.setInterpolator(new DecelerateInterpolator(1.2f));
            AnimatorSet set= new AnimatorSet();
            set.play(animator_title).with(animator_account).with(animator_password).with(animator_login).with(animator_noaccount);
            set.start();
        }else{
            ObjectAnimator animator_title = ObjectAnimator.ofFloat(tv_title_login,"translationY",0f,-2000f).setDuration(1000);
            animator_title.setInterpolator(new AnticipateInterpolator(1.2f));
            ObjectAnimator animator_account = ObjectAnimator.ofFloat(et_account,"translationY",0f,-2000f).setDuration(1000);
            animator_account.setInterpolator(new AnticipateInterpolator(1.4f));
            ObjectAnimator animator_password = ObjectAnimator.ofFloat(et_password,"translationY",0f,-2000f).setDuration(1000);
            animator_password.setInterpolator(new AnticipateInterpolator(1.6f));
            ObjectAnimator animator_login = ObjectAnimator.ofFloat(btn_login,"translationY",0f,-2000f).setDuration(1000);
            animator_login.setInterpolator(new AnticipateInterpolator(1.8f));
            ObjectAnimator animator_noaccount = ObjectAnimator.ofFloat(btn_noaccount,"translationY",0f,-2000f).setDuration(1000);
            animator_noaccount.setInterpolator(new AnticipateInterpolator(2f));
            AnimatorSet set= new AnimatorSet();
            set.play(animator_title).with(animator_account).with(animator_password).with(animator_login).with(animator_noaccount);
            set.start();
        }
    }
    //    注册页面动画，true为出现，false为消失
    private void animator_Regist(boolean type){
        if (type){
            ObjectAnimator animator_title = ObjectAnimator.ofFloat(tv_title_regist,"translationY",2000f,0f).setDuration(1000);
            animator_title.setInterpolator(new DecelerateInterpolator(2f));
            ObjectAnimator animator_account = ObjectAnimator.ofFloat(et_account_regist,"translationY",2000f,0f).setDuration(1000);
            animator_account.setInterpolator(new DecelerateInterpolator(1.8f));
            ObjectAnimator animator_password = ObjectAnimator.ofFloat(et_password_regist,"translationY",2000f,0f).setDuration(1000);
            animator_password.setInterpolator(new DecelerateInterpolator(1.6f));
            ObjectAnimator animator_reinput = ObjectAnimator.ofFloat(et_password_reinput,"translationY",2000f,0f).setDuration(1000);
            animator_reinput.setInterpolator(new DecelerateInterpolator(1.4f));
            ObjectAnimator animator_regist = ObjectAnimator.ofFloat(btn_regist,"translationY",2000f,0f).setDuration(1000);
            animator_regist.setInterpolator(new DecelerateInterpolator(1.2f));
            AnimatorSet set= new AnimatorSet();
            set.play(animator_title).with(animator_account).with(animator_password).with(animator_reinput).with(animator_regist);
            set.start();
        }else{
            ObjectAnimator animator_title = ObjectAnimator.ofFloat(tv_title_regist,"translationY",0f,-2000f).setDuration(1000);
            animator_title.setInterpolator(new AnticipateInterpolator(1.2f));
            ObjectAnimator animator_account = ObjectAnimator.ofFloat(et_account_regist,"translationY",0f,-2000f).setDuration(1000);
            animator_account.setInterpolator(new AnticipateInterpolator(1.4f));
            ObjectAnimator animator_password = ObjectAnimator.ofFloat(et_password_regist,"translationY",0f,-2000f).setDuration(1000);
            animator_password.setInterpolator(new AnticipateInterpolator(1.6f));
            ObjectAnimator animator_reinput = ObjectAnimator.ofFloat(et_password_reinput,"translationY",0f,-2000f).setDuration(1000);
            animator_reinput.setInterpolator(new AnticipateInterpolator(1.8f));
            ObjectAnimator animator_regist = ObjectAnimator.ofFloat(btn_regist,"translationY",0f,-2000f).setDuration(1000);
            animator_regist.setInterpolator(new AnticipateInterpolator(2f));
            AnimatorSet set= new AnimatorSet();
            set.play(animator_title).with(animator_account).with(animator_password).with(animator_reinput).with(animator_regist);
            set.start();
        }
    }

    //    账号查找，返回password，未找到则返回false
    private String searchAccountMethod(SQLiteDatabase db,String id){
        String searchAccount = "select * from userAccount where account = "+id+"";
        Cursor cursor = db.rawQuery(searchAccount,null);
        if (cursor.moveToNext()) {
//                int test_id = cursor.getInt(cursor.getColumnIndex("id"));
//                String test_account = cursor.getString(cursor.getColumnIndex("account"));
            String test_password = cursor.getString(cursor.getColumnIndex("password"));
//                Log.v("DB", "id:" + test_id + "\naccount:" + test_account + "\npassword:" + test_password);
            cursor.close();
            return test_password;
        }
        else {
//                Log.v("DB", "no result");
            cursor.close();
            return "false";
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Context context = getApplicationContext();
        findView();

//        创建数据库
        // 数据库userAccount
        // ID:int   integer
        // Account:String   text
        // Password:String  text
//        ------------------------------------------------------------------------------------MyMapDataBase---------------------------------------------------------
        final SQLiteDatabase db = openOrCreateDatabase("MyMapDataBase", Context.MODE_PRIVATE,null);
//        ------------------------------------------------------------------------------------MyMapDataBase---------------------------------------------------------
//        table: userAccount,  自增key
        String createString =
                "create table if not exists userAccount(id integer primary key autoincrement,account text not null,password text not null);";
        db.execSQL(createString);

//        ------------------------------------------------------------------------------------start_test------------------------------------------------------------
//        测试实例
        final ContentValues toInsert = new ContentValues();
//        toInsert.put("account","255255");
//        toInsert.put("password","8080");
//        db.insert("userAccount",null,toInsert);
//        toInsert.put("account","192202");
//        toInsert.put("password","9000");
//        db.insert("userAccount",null,toInsert);

//        查找id
//        Log.v("DB",searchAccountMethod(db,"255250"));
//        -----------------------------------------------------------------------------------test_finish------------------------------------------------------------


//        延时300ms启动 ?? 卡顿未解决
        setLoginVisiable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setLoginVisiable(true);
                animator_Login(true);
            }
        },300);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = et_account.getText()+"";
                String password = et_password.getText()+"";
//                账号为空
                if (account.equals("")) {
                    et_account.setHint("请输入账号");
                    ObjectAnimator animator_shake = ObjectAnimator.ofFloat(et_account,"translationX",0f,50f,0f).setDuration(500);
                    animator_shake.setInterpolator(new AnticipateOvershootInterpolator());
                    animator_shake.start();
                    et_account.requestFocus();
                }

//                密码为空
                else if(password.equals("")){
                    et_password.setHint("请输入密码");
                    ObjectAnimator animator_shake = ObjectAnimator.ofFloat(et_password,"translationX",0f,50f,0f).setDuration(500);
                    animator_shake.setInterpolator(new AnticipateOvershootInterpolator());
                    animator_shake.start();
                    et_password.requestFocus();
                }

//                账号不存在，请注册
                else if(searchAccountMethod(db,account).equals("false")){
                    Toast.makeText(LoginActivity.this, "账号不存在，请前往注册", Toast.LENGTH_SHORT).show();
                }

//                账号存在
                else{
                    //密码匹配
                    if(searchAccountMethod(db,account).equals(password)){
                        Toast.makeText(LoginActivity.this, "正在登陆，请稍后......", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        Bundle send = new Bundle();
                        send.putString("account",account);
                        intent.putExtras(send);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                        et_password.setText("");
                    }
                }
            }
        });


//        跳转注册按钮监听
        btn_noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator_Login(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setRegistVisiable(true);
                        animator_Regist(true);
                    }
                },700);
            }
        });

//        注册按钮监听
        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = et_account_regist.getText()+"";
                String password = et_password_regist.getText()+"";
//                账号为空
                if (account.equals("")) {
                    et_account_regist.setHint("请输入账号");
                    ObjectAnimator animator_shake = ObjectAnimator.ofFloat(et_account_regist,"translationX",0f,50f,0f).setDuration(500);
                    animator_shake.setInterpolator(new AnticipateOvershootInterpolator());
                    animator_shake.start();
                    et_account_regist.requestFocus();
                }

//                密码为空
                else if(password.equals("")){
                    et_password_regist.setHint("请输入密码");
                    ObjectAnimator animator_shake = ObjectAnimator.ofFloat(et_password_regist,"translationX",0f,50f,0f).setDuration(500);
                    animator_shake.setInterpolator(new AnticipateOvershootInterpolator());
                    animator_shake.start();
                    et_password_regist.requestFocus();
                }
//                重复密码为空
                else if(et_password_reinput.getText().toString().equals("")||
                        !et_password_reinput.getText().toString().equals(
                                password)){
                    et_password_reinput.setText("");
                    et_password_reinput.setHint("密码不正确");
                    ObjectAnimator animator_shake = ObjectAnimator.ofFloat(et_password_reinput,"translationX",0f,50f,0f).setDuration(500);
                    animator_shake.setInterpolator(new AnticipateOvershootInterpolator());
                    animator_shake.start();
                    et_password_reinput.requestFocus();
                }

//                账号不为空
                else if(!account.equals("")){
                    //未查找到的账号，执行注册
                    if(searchAccountMethod(db,account).equals("false")){
                        Log.v("DB","执行注册");
                        toInsert.put("account",account);
                        toInsert.put("password",password);
                        db.insert("userAccount",null,toInsert);

                        //注册成功
                        Toast.makeText(LoginActivity.this, "注册成功，快去登陆吧！", Toast.LENGTH_SHORT).show();
                        animator_Regist(false);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                animator_Login(true);
                                et_account_regist.setText("");
                                et_password_regist.setText("");
                                et_password_reinput.setText("");
                            }
                        }, 700);

                        et_account.setText(account);
                        et_password.setText(password);
                    }
                    //查找到此账号
                    else{
                        et_account_regist.setText("");
                        Toast.makeText(LoginActivity.this, "非常抱歉，该账号已被注册啦，请换个账号试试！", Toast.LENGTH_SHORT).show();
                        et_account_regist.setHint("此账号已存在");
                        Log.v("DB","账号已存在");
                    }
                }

            }
        });

    }
}
