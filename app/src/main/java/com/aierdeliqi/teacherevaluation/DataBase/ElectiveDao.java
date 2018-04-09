package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ElectiveDao {
    @Query("select * from ELECTIVE")
    List<Elective> getAll();
    @Query("select * from Elective where s_id =:s_Id")
    Elective get(long s_Id);
    @Insert
    void insertElective(Elective...electives);
    @Delete
    void deleteElective(Elective...electives);
    @Update
    void updateElective(Elective...electives);
}
