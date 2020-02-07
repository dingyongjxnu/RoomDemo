package com.dingyong.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by：dingyong on 2020/2/5 12:00
 * email：dingyongjxnu@163.com
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    public int mUid;
    @ColumnInfo(name = "first_name")
    public String mFirstName;
    @ColumnInfo(name = "last_name")
    public String mLastName;
    @Embedded
    public Address mAddress;

    @Override
    public String toString() {
        return "User{" +
                "mUid=" + mUid +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mAddress=" + mAddress +
                '}';
    }
}
