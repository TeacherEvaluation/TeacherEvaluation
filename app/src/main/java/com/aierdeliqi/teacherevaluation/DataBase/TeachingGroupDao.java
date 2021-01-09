package com.aierdeliqi.teacherevaluation.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeachingGroupDao {
    @Query("select * from TeachingGroup")
    List<TeachingGroup> getAll();
    @Query("select * from TeachingGroup where id=:Id")
    TeachingGroup getTeachingGroup(long Id);
    @Insert
    void insertTeachingGroup(TeachingGroup...teachingGroups);
    @Delete
    void deleteTeachingGroup(TeachingGroup...teachingGroups);
    @Update
    void updateTeachingGroup(TeachingGroup...teachingGroups);
}
