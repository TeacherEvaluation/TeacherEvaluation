package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AcademicDao {
    @Query("select * from Academic")
    List<Academic>getAll();
    @Query("select * from Academic where id=:index")
    Academic getAcademic(long index);
    @Insert
    void insertAcademic(Academic...academics);
    @Delete
    void deletetAcademic(Academic...academics);
    @Update
    void updateAcademic(Academic...academics);
}
