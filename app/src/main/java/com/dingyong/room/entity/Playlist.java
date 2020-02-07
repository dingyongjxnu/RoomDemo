package com.dingyong.room.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by：dingyong on 2020/2/6 09:41
 * email：dingyongjxnu@163.com
 */
@Entity
public class Playlist {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String description;

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

