package com.dingyong.room.entity;

import androidx.room.ColumnInfo;

/**
 * Created by：dingyong on 2020/2/5 17:45
 * email：dingyongjxnu@163.com
 */
public class Address {
    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postCode=" + postCode +
                '}';
    }
}
