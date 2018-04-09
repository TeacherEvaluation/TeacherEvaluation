package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TeacherDao {
    @Query("select * from Teacher")
    List<Teacher> getAll();
    @Query("select * from Teacher where id=:Id")
    Teacher getTeacher(long Id);
    @Delete
    void deleteTeacher(Teacher...teachers);
    @Update
    void updateTeacher(Teacher...teachers);
    @Insert
    void insertTeacher(Teacher...teachers);
}
