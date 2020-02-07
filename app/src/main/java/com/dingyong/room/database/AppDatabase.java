package com.dingyong.room.database;

import android.content.Context;

import com.dingyong.room.Dao.ClassDao;
import com.dingyong.room.Dao.PlaylistSongJoinDao;
import com.dingyong.room.Dao.StudentDao;
import com.dingyong.room.Dao.UserDao;
import com.dingyong.room.entity.ClassStu;
import com.dingyong.room.entity.Playlist;
import com.dingyong.room.entity.PlaylistSongJoin;
import com.dingyong.room.entity.Song;
import com.dingyong.room.entity.Student;
import com.dingyong.room.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by：dingyong on 2020/2/5 12:09
 * email：dingyongjxnu@163.com
 */
@Database(entities = {
        User.class,
        Student.class,
        ClassStu.class,
        Playlist.class,
        Song.class,
        PlaylistSongJoin.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "room_demo.db";
    private static AppDatabase sAppDatabase;


    public abstract UserDao getUserDao();

    public abstract StudentDao getStudentDao();

    public abstract ClassDao getClassStu();

    public abstract PlaylistSongJoinDao getPlaylistSongJoinDao();


    public static AppDatabase getInstance(Context context) {
        if (sAppDatabase == null) {
            synchronized (AppDatabase.class) {
                if (sAppDatabase == null) {
                    sAppDatabase = Room
                            .databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return sAppDatabase;
    }


}
