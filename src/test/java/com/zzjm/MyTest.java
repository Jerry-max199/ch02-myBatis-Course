package com.zzjm;

import com.zzjm.dao.StudentDao;
import com.zzjm.dao.StudentDaoImpl;
import com.zzjm.domain.Student;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void SelectTest(){
        //com.zzjm.dao.StudentDao
        StudentDao studentDao=new StudentDaoImpl();
        /**
         *  List<Student> studentList=studentDao.selectStudent();：调用
         *  1.dao对象，类型是StudentDao类型，全限定名称是com.zzjm.dao.StudentDao
         *      全限定名称和namespace是一样的
         *  2.方法名称，selectStudent,这个方法名就是mapper文件中id的值
         *  3.通过dao中方法的返回值也可以确定Mybatis要调用的sqlsession方法
         *      如果返回值类型是list，调用的是select方法
         *      如果返回值类型是int，调用的是insert或是update等方法
         *  mybatis的动态代理：mybatis根据dao的方法调用执行sql语句的信息
         *      mybatis根据你的dao接口，就会创建一个dao接口的实现类，并创建这个对象
         *      完成sqlSession调用方法，访问数据库。
         *
         */
        List<Student> studentList=studentDao.selectStudent();
        for (Student student:studentList){
            System.out.println(student);
        }
    }
    @Test
    public void insertTest(){
        StudentDao studentDao=new StudentDaoImpl();
        Student student=new Student();
        student.setId(1007);
        student.setName("公孙离");
        student.setEmail("gongsunli@163.com");
        student.setAge(18);
       int num= studentDao.insertStudent(student);
        System.out.println("加入"+num+"条数据");
    }
}
