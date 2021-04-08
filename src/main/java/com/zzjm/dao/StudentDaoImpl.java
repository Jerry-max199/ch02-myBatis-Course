package com.zzjm.dao;

import com.zzjm.domain.Student;
import com.zzjm.util.MyUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudent() {
        SqlSession sqlSession= MyUtil.getSession();
        String sql="com.zzjm.dao.StudentDao.selectStudent";
        List<Student> student=sqlSession.selectList(sql);
        sqlSession.close();
        return student;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession=MyUtil.getSession();
        String sqlId="com.zzjm.dao.StudentDao.insertStudent";
       int num=sqlSession.insert(sqlId,student);
       sqlSession.commit();
       sqlSession.close();
        return num;
    }
}
