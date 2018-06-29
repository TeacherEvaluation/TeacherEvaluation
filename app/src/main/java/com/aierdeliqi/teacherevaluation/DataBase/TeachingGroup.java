package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*
* 授课组*/
@Entity(tableName = "TeachingGroup")
public class TeachingGroup {
    /**
    * 授课组号*/
    @PrimaryKey
    private long id;
    /**
    * 组名*/
    @ColumnInfo(name = "name")
    private String name;

    public TeachingGroup() {
    }
    @Ignore
    public TeachingGroup(long id, @NonNull String name) {
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
