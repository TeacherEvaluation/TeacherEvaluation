package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.support.annotation.NonNull;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("select * from Student")
    List<Student> getAll();
    @Query("select * from Student where id=:Id")
    Student getStudent(@NonNull String Id);
    @Insert
    void insertStudent(Student...students);
    @Insert
    void insertStudent(List<Student> studentList);
    @Update
    void updateStudent(Student...students);
    @Delete
    void deleteStudent(Student...students);
}
