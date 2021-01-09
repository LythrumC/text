package demo_01;

import java.sql.*;

//测试使用JDBCuilts
public class jdbc_demo_01 {
    public static void main(String[] args) {
        selectALL_stu();
    }



    //查询所有学生
    public static void selectALL_stu(){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from student";
        try {
            con = JDBCuilts.getCon();
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
              while (resultSet.next())
                  System.out.println(resultSet.getString(1) + "-" + resultSet.getString(2) + "-" + resultSet.getString(3));
        }catch (Exception e){
            System.out.println("查询所有学生出现错误！");
        }finally {
            JDBCuilts.closeALL(resultSet,preparedStatement,con);
        }
    }




}
