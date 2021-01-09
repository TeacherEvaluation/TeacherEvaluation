package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

import java.util.List;

@Dao
public interface ProfessionDao {
    @Query("select * from Profession")
    List<Profession>getAll();
    @Query("select * from Profession where id=:Id")
    Profession getProfession(@NonNull String Id);
    @Insert
    void insertProfession(Profession...professions);
    @Update
    void updateProfession(Profession...professions);
    @Delete
    void deleteProfession(Profession...professions);
}
