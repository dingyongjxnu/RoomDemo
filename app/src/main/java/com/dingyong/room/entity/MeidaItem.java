package com.dingyong.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by：dingyong on 2020/2/7 15:16
 * email：dingyongjxnu@163.com
 */
@Entity
public class MeidaItem {
    @PrimaryKey
    public long id;
    public long mediaId;
    public String mData;
    public String time;
    public long dataTaken;
    public long modifyTime;
    public long addTime;
    public long buckId;
    public String realative;
}
