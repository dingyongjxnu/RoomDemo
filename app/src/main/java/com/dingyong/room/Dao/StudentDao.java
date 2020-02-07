package com.dingyong.room.Dao;

import com.dingyong.room.entity.Student;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by：dingyong on 2020/2/5 18:09
 * email：dingyongjxnu@163.com
 */
@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student... student);

    @Insert
    void insertStudent(List<Student> studentList);

    @Query("SELECT * FROM student")
    List<Student> queryAllStudent();
}
