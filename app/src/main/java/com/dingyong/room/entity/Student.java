package com.dingyong.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

/**
 * Created by：dingyong on 2020/2/5 17:35
 * email：dingyongjxnu@163.com
 * <p>
 * 一对多  外键
 */
@Entity(tableName = "student",
        foreignKeys = @ForeignKey(
                entity = ClassStu.class,
                parentColumns = "mId",
                childColumns = "class_id",
                onDelete = CASCADE)
)
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int mStuId;
    @ColumnInfo(name = "stu_name")
    public String mStuName;
    @ColumnInfo(name = "class_id")
    public int mClassId;

    @Override
    public String toString() {
        return "Student{" +
                "mStuId=" + mStuId +
                ", mStuName='" + mStuName + '\'' +
                ", mClassId=" + mClassId +
                '}';
    }
}
