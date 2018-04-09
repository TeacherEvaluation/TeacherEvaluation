package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.BuildConfig;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*职工信息*/
@Entity(tableName = "Teacher",
        foreignKeys = {@ForeignKey(entity =Teacher.class,parentColumns = "id", childColumns = "leader"),
                @ForeignKey(entity = TeachingGroup.class,parentColumns = "id", childColumns = "tg_id"),
                @ForeignKey(entity = Profession.class,parentColumns = "id", childColumns = "p_id")},
        indices = {@Index(value = {"id"},unique = true), @Index(value = "p_id",unique = true),
                @Index(value = "leader",unique = true),@Index(value = "tg_id",unique = true)})
public class Teacher {
    /*
    * 职工号*/
    @PrimaryKey
    private long id;
    /*
    * 个人基本信息*/
    @Embedded
    private People people;
    /*
     * 上一级领导*/
    @ColumnInfo(name = "leader")
    private long leader;
    /*
     * 授课组号*/
    @ColumnInfo(name = "tg_id")
    private long tg_id;
    /*
     * 专业号*/
    @ColumnInfo(name = "p_id")
    private long p_id;

    public Teacher() {
    }
    @Ignore
    public Teacher(long id, People people, long leader, long tg_id, long p_id) {
        this.id = id;
        this.people = people;
        this.leader = leader;
        this.tg_id = tg_id;
        this.p_id = p_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTg_id() {
        return tg_id;
    }

    public void setTg_id(long tg_id) {
        this.tg_id = tg_id;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public long getLeader() {
        return leader;
    }

    public void setLeader(long leader) {
        this.leader = leader;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
