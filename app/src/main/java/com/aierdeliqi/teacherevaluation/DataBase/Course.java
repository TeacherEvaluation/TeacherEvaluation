package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
* 课程信息*/
@Entity(tableName = "course")
public class Course {
    /**
    *课程号*/
    @PrimaryKey
    private long id;
    /**
    * 课程名*/
    @ColumnInfo(name = "name")
    private String name;

    public Course() {
    }
    @Ignore
    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
