package com.example.item.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDK连接SQL
 *
 * @author HXM
 * @date 2020年05月15日 17:02
 */
public class JDKJDBC {
    public static void main(String[] args) {
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/libmanage";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from goods_info";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            String job;
            String id;
            while (rs.next()) {
                //获取stuname这列数据
                job = rs.getString("job");
                //获取stuid这列数据
                id = rs.getString("ename");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (Exception e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }// TODO: handle exception
        finally {
            System.out.println("数据库数据成功获取！！");
        }
    }
}
