package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

/*
* 领导评价*/
@Entity(tableName = "LeadershipEvaluation",primaryKeys = {"ted_id","leader_id","NumberOfLectures"}
,foreignKeys = {@ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "ted_id"),
@ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "leader_id")},indices ={
@Index(value = {"ted_id"},unique = true),@Index(value = "leader_id",unique = true)})
public class LeadershipEvaluation {
    /*
    * 被听课教师职工号*/
    @ColumnInfo(name = "ted_id")
    @NonNull
    private String ted_id;
    /*
    * 领导职工号*/
    @ColumnInfo(name = "leader_id")
    @NonNull
    private String leader_id;

    public LeadershipEvaluation() {
    }
    @Ignore
    public LeadershipEvaluation(@NonNull String ted_id, @NonNull String leader_id, int numberOLectures, Evaluation evaluation) {
        this.ted_id = ted_id;
        this.leader_id = leader_id;
        NumberOLectures = numberOLectures;
        this.evaluation = evaluation;
    }

    /*
    * 听课次数*/
    @ColumnInfo(name = "NumberOfLectures")
    private int NumberOLectures;
    /*
    * 评价指标*/
    @Embedded
    private Evaluation evaluation;

    @NonNull
    public String getTed_id() {
        return ted_id;
    }

    public void setTed_id(@NonNull String ted_id) {
        this.ted_id = ted_id;
    }

    @NonNull
    public String getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(@NonNull String leader_id) {
        this.leader_id = leader_id;
    }

    public int getNumberOLectures() {
        return NumberOLectures;
    }

    public void setNumberOLectures(int numberOLectures) {
        NumberOLectures = numberOLectures;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
