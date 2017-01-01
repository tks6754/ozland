
import java.sql.*;

/**
 * Created by miaomu on 17-1-1.
 */
public class JdbcUtils {

    /**
     * 获得数据库连接
     * @return
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbdb?characterEncoding=utf-8", "root", "123");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取 预处理statement
     * @param sql
     * @param conn
     * @return
     */
    public static PreparedStatement getPreparedStatement(String sql, Connection conn){
        PreparedStatement pState = null;

        try {
            pState = conn.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pState;
    }

    /**
     * 获取 存储过程statement
     * @param sql
     * @param conn
     * @return
     */
    public static CallableStatement getCallableStatement(String sql, Connection conn){
        CallableStatement cState = null;

        try{
            cState = conn.prepareCall(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cState;
    }

    /**
     * 关闭 结果集
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭 statement
     * @param statement
     */
    public static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
