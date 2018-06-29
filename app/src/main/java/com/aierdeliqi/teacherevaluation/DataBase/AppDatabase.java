package com.aierdeliqi.teacherevaluation.DataBase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import java.io.Externalizable;
import java.io.ObjectStreamException;
/**
* 应用数据库接口*/
@Database(entities = {Course.class,Student.class,Profession.class,Teacher.class,TeachingGroup.class,
        StudentEvaluation.class,Elective.class,PeerReview.class,LeadershipEvaluation.class,Academic.class},version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase instance;
    public abstract CourseDao courseDao();
    public abstract ProfessionDao professionDao();
    public abstract StudentDao studentDao();
    public abstract StudentEvaluationDao studentEvaluationDao();
    public abstract TeacherDao teacherDao();
    public abstract TeachingGroupDao teachingGroupDao();
    public abstract ElectiveDao electiveDao();
    public abstract PeerReviewDao peerReviewDao();
    public abstract LeadershipEvaluationDao leadershipEvaluationDao();
    public abstract AcademicDao academicDao();
    /**
    * 单例模式中的双重检查锁实现*/
    public static synchronized AppDatabase getInstance(Context context) {
        if(instance==null) {
            synchronized (AppDatabase.class) {
                if (instance==null){
                    /*
                    * TODO:调试时的调用，发布时应删除allowMainThreadQueries()方法*/
                    instance= Room.databaseBuilder(context,AppDatabase.class,"Teacher" +
                            "Evaluation").allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
    /**
    * 关闭数据接口*/
    public static void onDestroy(){
        if(instance!=null) instance.close();
    }
    /**
    * 防止序列化破解单例*/
    protected AppDatabase() {
        if (instance!=null)throw new RuntimeException();
    }
    /**
    * 防止反序列化破解单例*/
    private Object readResolve()throws ObjectStreamException{
        return instance;
    }
}
