package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
