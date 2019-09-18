package com.dl.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

    static {
        InputStream is;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //sqlSessionFactory����
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //��ȡ���Ӷ���   sqlSession
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = tl.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            tl.set(sqlSession);
            return sqlSession;
        } else {
            return sqlSession;
        }
    }

    public static void close() {
        //����getSqlSession ��ȡsqlSession
        SqlSession sqlSession = getSqlSession();
        tl.remove();
        sqlSession.close();
        sqlSession = null;
    }

    //commit   myBatis �����ֶ��ύ���񣬹ر�����
    public static void commit() {
        SqlSession sqlSession = getSqlSession();
        sqlSession.commit();
        close();
    }


    public static void rollback() {
        SqlSession sqlSession = getSqlSession();
        sqlSession.rollback();
        close();
    }
}
