package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/*学生信息*/
@Entity(tableName = "Student",
        foreignKeys = {@ForeignKey(entity = Profession.class,parentColumns = "id"
                ,childColumns = "specialize")},indices = @Index(value = {"specialize"},unique = true))
public class Student {
    /**
    * 学号*/
    @PrimaryKey
    @NonNull
    private String id;
    /**
    * 个人基础信息*/
    @Embedded
    private People people;
    /**
    * 专业号*/
    @ColumnInfo(name = "specialize")
    private @NonNull String specialize;
    /**
    * 班级*/
    @ColumnInfo(name = "classes")
    private long classes;

    public Student() {
    }
    @Ignore
    public Student(@NonNull String id, People people, String specialize, long classes) {
        this.id = id;
        this.people = people;
        this.specialize = specialize;
        this.classes = classes;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @NonNull
    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(@NonNull String specialize) {
        this.specialize = specialize;
    }

    public long getClasses() {
        return classes;
    }

    public void setClasses(long classes) {
        this.classes = classes;
    }

}
