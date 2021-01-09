package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

import java.util.List;

@Dao
public interface StudentEvaluationDao {
    @Query("select * from StudentEvaluation")
    List<StudentEvaluation>getAll();
    @Query("select * from StudentEvaluation where s_id=:s_Id and c_id=:c_Id and t_id=:t_Id and " +
            "a_id=:a_Id and semester=:Semester and evaluation_type=:Evaluation_type")
    StudentEvaluation getStudentEvaluation(@NonNull String s_Id, long c_Id,@NonNull String t_Id, int a_Id, int Semester
    , int Evaluation_type);
    @Insert
    void insertStudentEvaluation(StudentEvaluation...studentEvaluations);
    @Delete
    void deleteStudentEvaluation(StudentEvaluation...studentEvaluations);
    @Update
    void updateStudentEvaluation(StudentEvaluation...studentEvaluations);
}
