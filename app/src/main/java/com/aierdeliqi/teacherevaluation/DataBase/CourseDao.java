package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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
