package com.aierdeliqi.teacherevaluation.mAdapter;

public class Talks {
    private String speaker;
    private String teacher;
    private String times;
    public Talks(){}
    public Talks(String speaker,String teacher,String time){
        this.speaker = speaker;
        this.teacher = teacher;
        this.times = time;
    }
    public String getSpeaker() {
        return speaker;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTimes() {
        return times;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTimes(String times) {
        this.times = times;
    }

}
