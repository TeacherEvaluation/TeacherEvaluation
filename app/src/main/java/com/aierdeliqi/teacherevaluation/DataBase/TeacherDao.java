package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

import java.util.List;

@Dao
public interface TeacherDao {
    @Query("select * from Teacher")
    List<Teacher> getAll();
    @Query("select * from Teacher where id=:Id")
    Teacher getTeacher(@NonNull String Id);
    @Delete
    void deleteTeacher(Teacher...teachers);
    @Update
    void updateTeacher(Teacher...teachers);
    @Insert
    void insertTeacher(Teacher...teachers);
}
