package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface AcademicDao {
    @Query("select * from Academic")
    List<Academic>getAll();
    @Query("select * from Academic where id=:index")
    Maybe<Academic> getAcademic(long index);
    @Insert
    void insertAcademic(Academic...academics);
    @Delete
    void deletetAcademic(Academic...academics);
    @Update
    void updateAcademic(Academic...academics);
}
