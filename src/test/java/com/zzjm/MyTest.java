package com.zzjm;

import com.zzjm.dao.StudentDaoImpl;
import com.zzjm.domain.Student;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void SelectTest(){
        StudentDaoImpl studentDao=new StudentDaoImpl();
        List<Student> studentList=studentDao.selectStudent();
        for (Student student:studentList){
            System.out.println(student);
        }
    }
}
