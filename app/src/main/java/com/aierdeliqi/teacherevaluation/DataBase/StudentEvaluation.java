package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

/*
* 学生评价*/
@Entity(tableName = "StudentEvaluation",
        primaryKeys = {"s_id","c_id","t_id","a_id","semester", "evaluation_type"},
        foreignKeys ={@ForeignKey(entity= Student.class,parentColumns = "id",childColumns = "s_id"),
                @ForeignKey(entity = Course.class,parentColumns = "id",childColumns = "c_id"),
                @ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "t_id"),
                @ForeignKey(entity = Academic.class,parentColumns = "id",childColumns = "a_id"),
                @ForeignKey(entity = Elective.class,parentColumns = "semester",childColumns = "semester")},
        indices = {@Index(value = "c_id",unique = true),@Index(value = "t_id",unique = true),
                @Index(value = "a_id",unique = true),@Index(value = "semester",unique = true)})
public class StudentEvaluation {
    /*
    * 学号*/
    @ColumnInfo(name = "s_id")
    private long s_id;
    /*
    * 课程号*/
    @ColumnInfo(name = "c_id")
    private long c_id;
    /*
    * 职工号*/
    @ColumnInfo(name = "t_id")
    private long t_id;
    /*
    * 学年编号*/
    private long a_id;
    /*
    * 学期*/
    @ColumnInfo(name = "semester")
    private int semester;
    /*
    * 评价类型：平时、期中和期末其值分别对应0，1，2*/
    @ColumnInfo(name = "evaluation_type")
    private int evaluation_type;
    /*
    * 评价指标*/
    @Embedded
    private Evaluation evaluation;

    public StudentEvaluation() {
    }
    @Ignore
    public StudentEvaluation(long s_id, long c_id, long t_id, long a_id, int semester, int evaluation_type, Evaluation evaluation) {
        this.s_id = s_id;
        this.c_id = c_id;
        this.t_id = t_id;
        this.a_id = a_id;
        this.semester = semester;
        this.evaluation_type = evaluation_type;
        this.evaluation = evaluation;
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
        return a_id;
    }

    public void setA_id(long a_id) {
        this.a_id = a_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getEvaluation_type() {
        return evaluation_type;
    }

    public void setEvaluation_type(int evaluation_type) {
        this.evaluation_type = evaluation_type;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
