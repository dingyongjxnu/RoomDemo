package com.dingyong.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by：dingyong on 2020/2/5 17:38
 * email：dingyongjxnu@163.com
 */
@Entity(tableName = "class_stu")
public class ClassStu {
    @PrimaryKey(autoGenerate = true)
    public int mId;
    @ColumnInfo(name = "class_name")
    public String mClassName;

    @Override
    public String toString() {
        return "ClassStu{" +
                "mId=" + mId +
                ", mClassName='" + mClassName + '\'' +
                '}';
    }
}
