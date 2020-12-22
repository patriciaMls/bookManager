package com.shixun.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/12/22 18:48
 * @version: 1.0
 * @modified By:
 */
public class DruidUtil {
    private static DataSource ds;
    private static DruidUtil druidUtil;
    // 静态代码块 - 建立druid连接池
    static {
        Properties properties = new Properties();
        InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        }catch (IOException e){
            System.out.println("DruidUtil properties.load(is) IOException");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("DruidUtil Exception");
            e.printStackTrace();
        }
    }

    public DruidUtil(){}

    public static DruidUtil getInstance(){
        if (druidUtil == null){
            druidUtil = new DruidUtil();
        }
        return druidUtil;
    }

    public Connection getConnection() throws SQLException {
        if (ds == null){
            System.out.println("DataSource is null");
            return null;
        }
        return ds.getConnection();
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null){
            conn.close();
        }
    }
}
