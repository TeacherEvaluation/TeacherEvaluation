package com.aierdeliqi.teacherevaluation;

import android.content.Context;

import com.aierdeliqi.teacherevaluation.DataBase.AppDatabase;
import com.aierdeliqi.teacherevaluation.DataBase.People;
import com.aierdeliqi.teacherevaluation.DataBase.Profession;
import com.aierdeliqi.teacherevaluation.DataBase.Student;

public  class CreateDB {
    public void text(Context context){
        //插入学生start
        Student student = new Student();
        People people = new People();
        Profession profession = new Profession();
        profession.setId("15340101");
        profession.setName("计算机");
        people.setAge(20);
        people.setFirst_name("张");
        people.setLast_name("荣盛");
        people.setPassword("123456");
        people.setSex("male");
        student.setId("153401010222");
        student.setClasses(1534);
        student.setPeople(people);
        student.setSpecialize(profession.getId());
        AppDatabase.getInstance(context).studentDao().insertStudent(student);
        //插入学生end
        AppDatabase.getInstance(context).studentDao().getStudent("153401010222");
    }
}
