package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Ignore;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/*
* 个人基本信息*/
public class People {
    /*
     * 姓名*/
    @ColumnInfo(name="name")
    private String name;
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
    public People(@NonNull String name, String sex, Bitmap head, @NonNull String password, int age) {
        this.name = name;
        this.sex = sex;
        this.head = head;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
