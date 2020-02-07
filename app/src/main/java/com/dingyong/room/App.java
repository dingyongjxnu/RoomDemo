package com.dingyong.room;

import android.app.Application;

import com.dingyong.room.database.AppDatabase;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by：dingyong on 2020/2/5 12:34
 * email：dingyongjxnu@163.com
 */
public class App extends Application {
    private AppDatabase mAppDatabase;
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_dev.db").addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }
        }).build();
    }

    public static App getInstance() {
        return mApp;
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
