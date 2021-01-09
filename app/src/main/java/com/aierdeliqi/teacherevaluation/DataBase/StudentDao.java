package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.annotation.NonNull;

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
