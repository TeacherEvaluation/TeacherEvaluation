package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Ignore;

public class Evaluation {
    /*
     * 教学内容*/
    private float content;
    /*
     * 教学态度*/
    private float attitude;
    /*
     * 教学方法与手段*/
    private float methods;
    /*
     * 教学状态*/
    private float status;
    /*
     *教学效果 */
    private float effect;
    /*
    * 评价时间*/
    private long times;
    public float getContent() {
        return content;
    }

    public void setContent(float content) {
        this.content = content;
    }

    public float getAttitude() {
        return attitude;
    }

    public void setAttitude(float attitude) {
        this.attitude = attitude;
    }

    public float getMethods() {
        return methods;
    }

    public void setMethods(float methods) {
        this.methods = methods;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public float getEffect() {
        return effect;
    }

    public void setEffect(float effect) {
        this.effect = effect;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    @Ignore
    public Evaluation(float content, float attitude, float methods, float status, float effect, long times) {
        this.content = content;
        this.attitude = attitude;
        this.methods = methods;
        this.status = status;
        this.effect = effect;
        this.times = times;
    }

    public Evaluation() {
    }
}
