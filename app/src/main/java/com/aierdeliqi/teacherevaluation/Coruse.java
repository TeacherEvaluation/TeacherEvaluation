package com.aierdeliqi.teacherevaluation;

public class Coruse {
    private String coruseName;
    private String teacherName;
    public Coruse(){}
    public Coruse(String coruseName,String teacherName){
        this.coruseName = coruseName;
        this.teacherName = teacherName;
    }

    public String getCoruseName() {
        return coruseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setCoruseName(String coruseName) {
        this.coruseName = coruseName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
