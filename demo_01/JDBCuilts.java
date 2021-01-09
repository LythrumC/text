package demo_01;

import java.sql.*;
import java.util.ArrayList;

//JDBC连接工具
public class JDBCuilts {
    static ArrayList<Connection> conlist = new ArrayList<>();//手动创建连接池
    static final String url = "jdbc:mysql://localhost:3306/xkgl?useSSL=false&serverTimezone=UTC";
    static final String user  = "root";
    static final String password = "2902044ck";

    //静态代码块，JVM启动时调用
    static {
        for (int i = 0; i < 5; i++) {
            Connection con = createCon();
            conlist.add(con);
        }
    }

    //创建连接
    public static Connection createCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //注册JDBC驱动
            Connection con = DriverManager.getConnection(url,user,password);
            return con;
        } catch (Exception throwables) { System.out.println("连接出现问题"); }
        //连接失败，则返回null
        return null;
    }

    //拿取连接（从连接池中拿去，连接池没有就创建一个新的）
    public static Connection getCon(){
        if (!conlist.isEmpty()) {
            Connection con = conlist.get(0);
            conlist.remove(0);
            return con;
        }else {
            return createCon();
        }
    }

    //关闭连接，并归还给连接池conlist
    public static void closeCon(Connection con){
        //直接把这个连接加入到连接池conlist中
        conlist.add(con);
    }
    //关闭Statement
    public static void closeState(Statement statement){
        try {
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) { System.out.println("关闭Statement失败"); }
    }
    //关闭preparedStatement
    public static void closePreState(PreparedStatement preparedStatement){
        try {
            if(preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException throwables) { System.out.println("关闭preparedStatement失败"); }
    }
    //关闭resultSet
    public static void closeResultset(ResultSet resultSet){
        try {
            if(resultSet != null)
                resultSet.close();
        } catch (SQLException throwables) { System.out.println("关闭preparedStatement失败"); }
    }

    //一键关闭
    public static void closeALL(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection){
         closeResultset(resultSet);
         closePreState(preparedStatement);
         closeCon(connection);
    }
}
