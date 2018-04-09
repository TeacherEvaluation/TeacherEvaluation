package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

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
