package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/*
* 学年*/
@Entity(tableName = "Academic",indices = @Index(value = "name",unique = true))
public class Academic {
    /**
    * id ：学年编号*/
    @PrimaryKey(autoGenerate = true)
    private long id;
    /**
    * name:具体学年,格式为：yyyy-yyyy,例如：2016-2017*/
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
