package com.zzjm.util;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyUtil {

    private static SqlSessionFactory sqlSessionFactory=null;
    static {
        String config="mybatis.xml";
        try {
            InputStream inputStream= Resources.getResourceAsStream(config);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSession(){
    SqlSession sqlSession=null;
    if (sqlSessionFactory!=null){
         sqlSession=sqlSessionFactory.openSession();
    }
    return sqlSession;
    }
}
