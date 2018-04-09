package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*
* 学年*/
@Entity(tableName = "Academic",indices = @Index(value = "name",unique = true))
public class Academic {
    /*
    * 学年编号*/
    @PrimaryKey(autoGenerate = true)
    private long id;
    /*
    * 具体学年,格式为：yyyy-yyyy,例如：2016-2017*/
    @ColumnInfo(name = "name")
    private String name;

    public Academic() {
    }
    @Ignore
    public Academic(@NonNull String name) {
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

    public void setName(String name) {
        this.name = name;
    }
}
