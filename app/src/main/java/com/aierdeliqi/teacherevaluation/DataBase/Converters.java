package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.TypeConverter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.Date;

/**
* 转换器*/
public class Converters {
    /**
     * Long类型转为Date类型
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }
    /**
     * Date类型转为Long类型*/
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
    /**
    * 位图转换为byte[]数组*/
    @TypeConverter
    public static Bitmap fromBytes(byte[] value) {
        return BitmapFactory.decodeByteArray(value,0,value.length,null);
    }
    /**
     * 字节数组转位图*/
    @TypeConverter
    public static byte[] BitmapToBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
