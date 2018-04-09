package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ProfessionDao {
    @Query("select * from Profession")
    List<Profession>getAll();
    @Query("select * from Profession where id=:Id")
    Profession getProfession(long Id);
    @Insert
    void insertProfession(Profession...professions);
    @Update
    void updateProfession(Profession...professions);
    @Delete
    void deleteProfession(Profession...professions);
}
