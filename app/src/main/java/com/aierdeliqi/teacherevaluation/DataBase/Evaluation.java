package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import java.util.Date;
/**
* 评价信息*/
public class Evaluation {
    /**
    * 评价指标*/
    private @NonNull String index;
    /**
    * 子因素*/
    private @NonNull String sub_factors;
    /**
    * 等级*/
    private @NonNull String grade;
    /**
    * 等级对应的三角模糊数分值*/
    private float value;
    /**
    * 评价时间*/
    private Date times;

    public Evaluation() {
    }
    @Ignore
    public Evaluation(@NonNull String index, @NonNull String sub_factors, @NonNull String grade, float value, Date times) {
        this.index = index;
        this.sub_factors = sub_factors;
        this.grade = grade;
        this.value = value;
        this.times = times;
    }

    @NonNull
    public String getIndex() {
        return index;
    }

    public void setIndex(@NonNull String index) {
        this.index = index;
    }

    @NonNull
    public String getSub_factors() {
        return sub_factors;
    }

    public void setSub_factors(@NonNull String sub_factors) {
        this.sub_factors = sub_factors;
    }

    @NonNull
    public String getGrade() {
        return grade;
    }

    public void setGrade(@NonNull String grade) {
        this.grade = grade;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

}
