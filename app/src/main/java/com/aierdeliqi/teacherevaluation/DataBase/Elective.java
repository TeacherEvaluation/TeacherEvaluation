package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.annotation.NonNull;

/**
* 选课信息*/
@Entity(tableName = "Elective",primaryKeys = {"s_id","c_id","t_id","A_id","semester"},
        foreignKeys = {@ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "t_id"),
                @ForeignKey(entity = Student.class,parentColumns = "id",childColumns = "s_id"),
                @ForeignKey(entity = Course.class,parentColumns = "id",childColumns = "c_id")},
        indices ={@Index(value = "t_id",unique = true),@Index(value = "c_id",unique = true),
                @Index(value = "A_id",unique = true),@Index(value = "semester",unique = true)})
public class Elective {
    /**
    * 学号*/
    @ColumnInfo(name = "s_id")
    private long s_id;
    /**
    * 课程号*/
    @ColumnInfo(name="c_id")
    private long c_id;
    /**
    * 职工号*/
    @ColumnInfo(name="t_id")
    private long t_id;
    /**
    * 学年编号*/
    @ColumnInfo(name = "A_id")
    private long A_id;
    /**
    * 学期*/
    @ColumnInfo(name = "semester")
    private int semester;
    /**
    * 成绩*/
    @ColumnInfo(name = "score")
    private int score;

    public Elective() {
    }
    @Ignore
    public Elective(long s_id, long c_id, long t_id, long a_id, int semester, int score) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.t_id = t_id;
        A_id = a_id;
        this.semester = semester;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public long getC_id() {
        return c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public long getT_id() {
        return t_id;
    }

    public void setT_id(long t_id) {
        this.t_id = t_id;
    }

    public long getA_id() {
        return A_id;
    }

    public void setA_id(long a_id) {
        A_id = a_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
