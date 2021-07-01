package com.example.item.zrExam.eightSecureTest;

import com.example.item.tools.encryption.Encrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <pre>
 *  模拟登录程序优化，优化要求如下：
 * 1）、修改encode和decode方法，使用户名和密码在main方法加密，在loginTest方法中解密后验证登录。
 * 2）、修改getCheckSn方法使key返回值不为空，并用key作为userName和userPwd是否调用changeData做出验证是否数据变更的判断依据。
 * 3）、优化loginTest方法防止userPwd =" test' or '1' = '1 " 和userName =" test ' or '1' = '1 " 的SQL注入攻击。
 * 4）、优化loginTest方法防止tableName = " test where 1 = 1 -- "的SQL注入攻击
 * </pre>
 */
public class SqlTest {

    public static void main(String[] args) throws Exception {
        String tableName = "sm_test";
        String username = "tests";
        String password = "test";
        User user = new User(encode(username), encode(password));
        String key = getCheckSn(user.getUserName(), user.getUserPwd());
        // 测试的时候调用,模拟传输过程中别改变数据信息
//        changeData(user);
        System.out.println(user);
        loginTest(tableName, user, key);
    }

    /**
     * <pre> 模拟登录方法</pre>
     */
    public static void loginTest(String tableName, User user, String key) throws Exception {
        String currKey = getCheckSn(user.getUserName(), user.getUserPwd());
        if (key.equals(currKey)) {
            System.out.println("Data not change!" + user);
            user.setUserName(decode(user.getUserName()));
            user.setUserPwd(decode(user.getUserPwd()));
        } else {
            System.out.println("Data was change!" + user);
        }
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://39.106.114.95:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "199678");
        Statement state = conn.createStatement();
        String sql = "select * from " + tableName + " where user = '" + user.getUserName() + "' and password = '" + user.getUserPwd() + "' ";
        ResultSet rs = state.executeQuery(sql);
        boolean ok = rs.next();
        if (ok) {
            System.out.println("欢迎" + rs.getString(1) + "回来");
        } else {
            System.out.println("您输入的账号密码错误");
        }
        conn.close();
    }

    /**
     * <pre>通过username, userPwd产生Key</pre>
     */
    public static String getCheckSn(String userName, String userPwd) {
        return Encrypt.encrypt(userName, userPwd);
    }

    /**
     * <pre>测试方法，不允许修改</pre>
     */
    public static void changeData(User user) {
        user.setUserName(user.getUserName() + "_1");
        user.setUserPwd(user.getUserPwd() + "_1");
    }

    /**
     * <pre>加密方法</pre>
     */
    public static String encode(String param) {
        return Encrypt.encrypt(param);
    }

    /**
     * <pre>解密方法</pre>
     */
    public static String decode(String param) {
        return Encrypt.decrypt(param);
    }
}