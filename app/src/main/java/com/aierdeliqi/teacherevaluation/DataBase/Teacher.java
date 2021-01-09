package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
*职工信息*/
@Entity(tableName = "Teacher",
        foreignKeys = {@ForeignKey(entity =Teacher.class,parentColumns = "id", childColumns = "leader"),
                @ForeignKey(entity = TeachingGroup.class,parentColumns = "id", childColumns = "tg_id"),
                @ForeignKey(entity = Profession.class,parentColumns = "id", childColumns = "p_id")},
        indices = {@Index(value = {"id"},unique = true), @Index(value = "p_id",unique = true),
                @Index(value = "leader",unique = true),@Index(value = "tg_id",unique = true)})
public class Teacher {
    /**
    * 职工号*/
    @PrimaryKey
    @NonNull
    private String  id;
    /**
    * 个人基本信息*/
    @Embedded
    private People people;
    /**
     * 上一级领导*/
    @ColumnInfo(name = "leader")
    private String leader;
    /**
     * 授课组号*/
    @ColumnInfo(name = "tg_id")
    private long tg_id;
    /**
     * 专业号*/
    @ColumnInfo(name = "p_id")
    private @NonNull String p_id;

    public Teacher() {
    }
    @Ignore
    public Teacher(@NonNull String id, People people, String leader, long tg_id, String p_id) {
        this.id = id;
        this.people = people;
        this.leader = leader;
        this.tg_id = tg_id;
        this.p_id = p_id;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTg_id() {
        return tg_id;
    }

    public void setTg_id(long tg_id) {
        this.tg_id = tg_id;
    }

    @NonNull
    public String getP_id() {
        return p_id;
    }

    public void setP_id(@NonNull String p_id) {
        this.p_id = p_id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
