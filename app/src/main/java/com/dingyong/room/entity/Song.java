package com.dingyong.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by：dingyong on 2020/2/6 09:41
 * email：dingyongjxnu@163.com
 */
@Entity
public class Song {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String songName;
    public String artistName;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}

