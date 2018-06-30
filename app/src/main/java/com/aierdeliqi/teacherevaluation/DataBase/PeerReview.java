package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

/*
* 同行评价*/
@Entity(tableName = "PeerReview",primaryKeys = {"tg_id","ted_id","ting_id"},foreignKeys = {
        @ForeignKey(entity = TeachingGroup.class,parentColumns = "id",childColumns = "tg_id"),
        @ForeignKey(entity = Teacher.class,parentColumns = {"id"},childColumns = {"ted_id",}),
        @ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "ting_id")},
        indices = {@Index(value = "tg_id",unique = true),@Index(value = "ted_id",unique = true),
        @Index(value = "ting_id",unique = true)})
public class PeerReview {
    /*
    * 授课组号*/
    @ColumnInfo(name = "tg_id")
    private long tg_id;
    /*
    * 被评人职工号*/
    @ColumnInfo(name = "ted_id")
    private @NonNull String ted_id;
    /*
    * 评价人职工号*/
    @ColumnInfo(name = "ting_id")
    private @NonNull String ting_id;
    /*
    * 评价指标*/
    @Embedded
    private Evaluation evaluation;

    public PeerReview() {
    }
    @Ignore
    public PeerReview(long tg_id, @NonNull String ted_id, @NonNull String ting_id, Evaluation evaluation) {
        this.tg_id = tg_id;
        this.ted_id = ted_id;
        this.ting_id = ting_id;
        this.evaluation = evaluation;
    }

    public long getTg_id() {
        return tg_id;
    }

    public void setTg_id(long tg_id) {
        this.tg_id = tg_id;
    }

    @NonNull
    public String getTed_id() {
        return ted_id;
    }

    public void setTed_id(@NonNull String ted_id) {
        this.ted_id = ted_id;
    }

    @NonNull
    public String getTing_id() {
        return ting_id;
    }

    public void setTing_id(@NonNull String ting_id) {
        this.ting_id = ting_id;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
