package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentEvaluationDao {
    @Query("select * from StudentEvaluation")
    List<StudentEvaluation>getAll();
    @Query("select * from StudentEvaluation where s_id=:s_Id and c_id=:c_Id and t_id=:t_Id and " +
            "a_id=:a_Id and semester=:Semester and evaluation_type=:Evaluation_type")
    StudentEvaluation getStudentEvaluation(long s_Id,long c_Id,long t_Id,int a_Id,int Semester
    ,int Evaluation_type);
    @Insert
    void insertStudentEvaluation(StudentEvaluation...studentEvaluations);
    @Delete
    void deleteStudentEvaluation(StudentEvaluation...studentEvaluations);
    @Update
    void updateStudentEvaluation(StudentEvaluation...studentEvaluations);
}
