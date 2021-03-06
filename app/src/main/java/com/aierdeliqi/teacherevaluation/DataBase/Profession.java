package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/*
* 专业信息*/
@Entity(tableName = "Profession")
public class Profession {
    /*
    * 专业号*/
    @PrimaryKey
    @NonNull
    private String id;
    /*
    * 专业名*/
    @ColumnInfo(name = "name")
    private String name;

    public Profession() {
    }
    @Ignore
    public Profession(@NonNull String id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
