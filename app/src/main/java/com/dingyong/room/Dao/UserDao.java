package com.dingyong.room.Dao;

import com.dingyong.room.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by：dingyong on 2020/2/5 12:03
 * email：dingyongjxnu@163.com
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void inser(User... user);

    @Insert
    void inser(List<User> user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE mUid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE mUid IN (:ids)")
    List<User> loadAllByIds(List<Integer> ids);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE mUid = (:id)")
    User findById(int id);

    @Query("DELETE FROM user WHERE mUid IN(:ids)")
    void delete(List<Integer> ids);

    @Update
    void update(User... users);

    @Query("SELECT * FROM user WHERE:where")
    List<User> query(String where);
}
