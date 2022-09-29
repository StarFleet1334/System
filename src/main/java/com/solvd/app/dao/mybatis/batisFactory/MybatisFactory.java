package com.solvd.app.dao.mybatis.batisFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;


public class MybatisFactory {
    private static final Logger LOGGER = LogManager.getLogger(MybatisFactory.class);

    private static MybatisFactory instance;

    private MybatisFactory() {}

    public static SqlSessionFactory getSqlSessionFactory() {
        if (instance == null) {
            synchronized (MybatisFactory.class) {
                if (instance == null) {
                    try {
                        instance = new MybatisFactory();
                        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
                        return  sqlSessionFactoryBuilder.build(reader);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
