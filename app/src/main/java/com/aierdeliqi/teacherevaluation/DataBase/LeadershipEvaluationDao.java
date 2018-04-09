package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LeadershipEvaluationDao {
    @Query("select * from LeadershipEvaluation")
    List<LeadershipEvaluation>getAll();
    @Query("select * from LeadershipEvaluation where ted_id=:ted_Id and leader_id=:leader_Id" +
            " and NumberOfLectures=:numberOfLectures")
    LeadershipEvaluation getLeadershipEvaluation(long ted_Id,long leader_Id,int numberOfLectures);
    @Insert
    void insertLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
    @Delete
    void deleteLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
    @Update
    void updateLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
}
