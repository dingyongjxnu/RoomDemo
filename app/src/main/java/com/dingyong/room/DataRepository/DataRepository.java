package com.dingyong.room.DataRepository;

import android.content.Context;

import com.dingyong.room.database.AppDatabase;
import com.dingyong.room.entity.ClassStu;
import com.dingyong.room.entity.Playlist;
import com.dingyong.room.entity.PlaylistSongJoin;
import com.dingyong.room.entity.Song;
import com.dingyong.room.entity.Student;
import com.dingyong.room.entity.User;

import java.util.List;

/**
 * Created by：dingyong on 2020/2/5 14:07
 * email：dingyongjxnu@163.com
 */
public class DataRepository {
    private final AppDatabase mDatabase;
    private static DataRepository sInstance;

    private DataRepository(AppDatabase appDatabase) {
        mDatabase = appDatabase;
    }

    public static DataRepository getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(AppDatabase.getInstance(context));
                }
            }
        }
        return sInstance;
    }

    public List<User> getAll() {
        return mDatabase.getUserDao().getAll();
    }

    public void inser(User... user) {
        mDatabase.getUserDao().inser(user);
    }

    public void inser(List<User> user) {
        mDatabase.getUserDao().inser(user);
    }

    public void delete(User user) {
        mDatabase.getUserDao().delete(user);
    }


    public List<User> loadAllByIds(int[] userIds) {
        return mDatabase.getUserDao().loadAllByIds(userIds);
    }

    public List<User> loadAllByIds(List<Integer> ids) {
        return mDatabase.getUserDao().loadAllByIds(ids);
    }

    public User findByName(String first, String last) {
        return mDatabase.getUserDao().findByName(first, last);
    }

    public User findById(int id) {
        return mDatabase.getUserDao().findById(id);
    }

    public void delete(List<Integer> ids) {
        mDatabase.getUserDao().delete(ids);
    }

    public void update(User... users) {
        mDatabase.getUserDao().update(users);
    }


    public void insertStudent(Student... student) {
        mDatabase.getStudentDao().insertStudent(student);
    }


    public void insertStudent(List<Student> studentList) {
        mDatabase.getStudentDao().insertStudent(studentList);
    }


    public List<Student> queryAllStudent() {
        return mDatabase.getStudentDao().queryAllStudent();
    }

    public List<ClassStu> queryAllClass() {
        return mDatabase.getClassStu().queryAllClass();
    }

    public void insertClassStu(List<ClassStu> classStuList) {
        mDatabase.getClassStu().insertClass(classStuList);
    }

    public void insert(PlaylistSongJoin playlistSongJoin) {
        mDatabase.getPlaylistSongJoinDao().insert(playlistSongJoin);
    }


    public void insert(Playlist playlist) {
        mDatabase.getPlaylistSongJoinDao().insert(playlist);
    }


    public void insert(Song song) {
        mDatabase.getPlaylistSongJoinDao().insert(song);
    }

    public List<Playlist> getPlaylistsForSong(final int songId) {
        return mDatabase.getPlaylistSongJoinDao().getPlaylistsForSong(songId);
    }


    public List<Song> getSongsForPlaylist(final int playlistId) {
        return mDatabase.getPlaylistSongJoinDao().getSongsForPlaylist(playlistId);
    }


    public List<Song> getAllSong() {
        return mDatabase.getPlaylistSongJoinDao().getAllSong();
    }


    public List<Playlist> getAllPlayList() {
        return mDatabase.getPlaylistSongJoinDao().getAllPlayList();
    }

    public List<User> query(String where) {
        return mDatabase.getUserDao().query(where);
    }
}
