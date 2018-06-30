package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/*
* 个人基本信息*/
public class People {
    /*
     * 姓名中的第一个字：姓*/
    @NonNull
    @ColumnInfo(name="first_name")
    private String first_name;
    /*
    * @Parameter
    * 姓名中的后几个字*/
    @NonNull
    @ColumnInfo(name = "last_name")
    private String last_name;
    /*
     * 性别*/
    @ColumnInfo(name = "sex")
    private String sex;
    /*
    * 头像*/
    @Ignore
    @ColumnInfo(name = "head")
    private Bitmap head;
    /*
     * 密码*/
    @ColumnInfo(name = "password")
    private String password;
    /*
     * 年龄*/
    @ColumnInfo(name = "age")
    private int age;

    public People() {
    }
    @Ignore
    public People(@NonNull String first_name, @NonNull String last_name, String sex, Bitmap head, String password, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.sex = sex;
        this.head = head;
        this.password = password;
        this.age = age;
    }

    @NonNull
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(@NonNull String first_name) {
        this.first_name = first_name;
    }

    @NonNull
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(@NonNull String last_name) {
        this.last_name = last_name;
    }

    public Bitmap getHead() {
        return head;
    }

    public void setHead(Bitmap head) {
        this.head = head;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
