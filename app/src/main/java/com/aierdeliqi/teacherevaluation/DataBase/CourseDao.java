package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseDao {
    @Query("select * from COURSE")
    List<Course> getAll();
    @Query("select * from COURSE where id =:number")
    Course getCourse(long number);
    @Insert
    void insertCourse(Course...courses);
    @Update
    void updateCourse(Course...courses);
    @Delete
    void deleteCourse(Course...courses);
}
