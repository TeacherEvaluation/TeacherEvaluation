package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

import java.util.List;

@Dao
public interface LeadershipEvaluationDao {
    @Query("select * from LeadershipEvaluation")
    List<LeadershipEvaluation>getAll();
    @Query("select * from LeadershipEvaluation where ted_id=:ted_Id and leader_id=:leader_Id" +
            " and NumberOfLectures=:numberOfLectures")
    LeadershipEvaluation getLeadershipEvaluation(@NonNull String ted_Id,@NonNull String leader_Id, int numberOfLectures);
    @Insert
    void insertLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
    @Delete
    void deleteLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
    @Update
    void updateLeadershipEvaluation(LeadershipEvaluation...leadershipEvaluations);
}
