package com.aierdeliqi.teacherevaluation;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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

import com.aierdeliqi.teacherevaluation.DataBase.AppDatabase;
import com.aierdeliqi.teacherevaluation.DataBase.Student;
import com.aierdeliqi.teacherevaluation.DataBase.Teacher;
import com.rey.material.widget.Button;

public class LoginActivity extends AppCompatActivity implements Spinner.OnItemSelectedListener, View.OnClickListener {
    Spinner sp_account;
    ImageButton ib_logo;
    CardView cardView,card_login;
    TextView tv_rebuild;
    LinearLayout ll_sp;
    EditText et_account, et_password;
    Boolean state = true;
    Button btn_login;
    Boolean is_update;

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

    private String account_update=null;//修改密码时临时保存账号
    @SuppressLint("StaticFieldLeak")
    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.tv_rebuild) {
            obanime();
            ll_sp.setVisibility(View.GONE);
            et_account.setHint("修改密码:");
            account_update=et_account.getText()+"";
            et_account.setText(null);
            et_password.setHint("再次输入密码:");
            tv_rebuild.setVisibility(View.INVISIBLE);
            btn_login.setText("确认");
            if(account_update.isEmpty()){
                Toast.makeText(this,R.string.login_error,Toast.LENGTH_SHORT).show();
            }
            state = !state;
        }
        else if (v.getId() == R.id.btn_login){
            if (!state) {
                final String password=et_account.getText()+"";
                String password1=et_password.getText()+"";
                if(password.equals(password1)) {
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setTitle(R.string.reset_password);
                    progressDialog.setMessage(getResources().getString(R.string.logining));
                    new AsyncTask<Context, Void, Boolean>() {
                        @Override
                        protected void onPreExecute() {
                            progressDialog.show();
                            super.onPreExecute();
                        }

                        @Override
                        protected Boolean doInBackground(Context... contexts) {
                            if (sp_account.getSelectedItemPosition() == 0) {
                                Student student = AppDatabase.getInstance(contexts[0]).studentDao().getStudent(account_update);
                                if (student != null) {
                                    student.getPeople().setPassword(password);
                                    AppDatabase.getInstance(contexts[0]).studentDao().updateStudent(student);
                                    return true;
                                }
                            } else {
                                Teacher teacher = AppDatabase.getInstance(contexts[0]).teacherDao().getTeacher(account_update);
                                if (teacher != null) {
                                    teacher.getPeople().setPassword(password);
                                    AppDatabase.getInstance(contexts[0]).teacherDao().updateTeacher(teacher);
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override
                        protected void onPostExecute(Boolean aBoolean) {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, aBoolean ? R.string.update_success : R.string.update_error, Toast.LENGTH_SHORT).show();
                            super.onPostExecute(aBoolean);
                        }
                    }.execute(this);
                    obanime();
                    ll_sp.setVisibility(View.VISIBLE);
                    et_account.setHint("账号:");
                    et_password.setHint("密码:");
                    btn_login.setText("登陆");
                    tv_rebuild.setVisibility(View.VISIBLE);
                    state = !state;
                }else {
                    Toast.makeText(this,R.string.update_password_error,Toast.LENGTH_SHORT).show();
                }
            }else {
                final String account = et_account.getText()+"";
                final String password= et_password.getText()+"";
                if (account.isEmpty()){
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                }else if(password.isEmpty()){
                    Toast.makeText(this,R.string.passwordIsEmptyTip,Toast.LENGTH_SHORT).show();
                }
                else {
                    final ProgressDialog progressDialog=new ProgressDialog(this);
                    progressDialog.setTitle(R.string.logining);
                    progressDialog.setMessage(getResources().getString(R.string.waitting));
                    new AsyncTask<Context,Void,Boolean>(){
                        @Override
                        protected void onPreExecute() {
                            progressDialog.show();
                            super.onPreExecute();
                        }

                        @Override
                        protected Boolean doInBackground(Context... contexts) {
                            if(sp_account.getSelectedItemPosition()==0)
                            {
                                Student student=AppDatabase.getInstance(contexts[0]).studentDao().getStudent(account);
                                return student != null && student.getPeople().getPassword().equals(password);
                            }else {
                                Teacher teacher=AppDatabase.getInstance(contexts[0]).teacherDao().getTeacher(account);
                                return teacher != null && teacher.getPeople().getPassword().equals(password);
                            }
                        }

                        @Override
                        protected void onPostExecute(Boolean aBoolean) {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this,aBoolean?R.string.login_success:R.string.login_error,Toast.LENGTH_SHORT).show();
                            if(aBoolean)
                            {
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            }
                            super.onPostExecute(aBoolean);
                        }
                    }.execute(this);
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
