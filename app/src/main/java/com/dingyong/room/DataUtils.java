package com.dingyong.room;

import com.dingyong.room.entity.ClassStu;
import com.dingyong.room.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by：dingyong on 2020/2/5 18:18
 * email：dingyongjxnu@163.com
 */
public class DataUtils {
    public static List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student student = new Student();
            student.mStuName = "student-" + i;
            student.mClassId = 1;
            students.add(student);
        }
        return students;
    }

    public static List<ClassStu> getClassList() {
        List<ClassStu> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ClassStu student = new ClassStu();
            if (i % 3 == 0) {
                student.mClassName = "class_0";
            } else if (i % 3 == 1) {
                student.mClassName = "class_1";
            } else {
                student.mClassName = "class_2";
            }
            students.add(student);
        }
        return students;
    }
}
