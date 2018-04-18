package com.aierdeliqi.teacherevaluation.mAdapter;

public class Coruse {
    private String coruseName;
    private String teacherName;
    private Boolean issubmit;
    public Coruse(){}

    public Coruse(String coruseName, String teacherName) {
        this.coruseName = coruseName;
        this.teacherName = teacherName;
        this.issubmit = false;
    }

    public String getCoruseName() {
        return coruseName;
    }

    public void setCoruseName(String coruseName) {
        this.coruseName = coruseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Boolean getIssubmit() {
        return issubmit;
    }

    public void setIssubmit(Boolean issubmit) {
        this.issubmit = issubmit;
    }
}
