package com.dingyong.room.Dao;

import com.dingyong.room.entity.ClassStu;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by：dingyong on 2020/2/5 18:09
 * email：dingyongjxnu@163.com
 */
@Dao
public interface ClassDao {
    @Insert
    void insertClass(ClassStu... student);

    @Insert
    void insertClass(List<ClassStu> studentList);

    @Query("SELECT * FROM class_stu")
    List<ClassStu> queryAllClass();
}
