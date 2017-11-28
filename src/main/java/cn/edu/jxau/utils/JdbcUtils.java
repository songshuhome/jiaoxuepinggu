package cn.edu.jxau.utils;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import cn.edu.jxau.utils.druip.DataSourceUtil;

/**
 * 使用本类的方法，必须提供c3p0-copnfig.xml文件
 * 结合事务的原理就是给一个Connection，但是需要保证是同一个Connection，这个时候就需要用ThreadLocal线程。
 * 运用了ThreadLocal来管理我们的Connection。以后处理事务的时候需要的Connection都是从ThreadLocal里面拿，这样能保证是同一个Connection
 * JdbcUtils
 * @author zclong 2017年7月28日
 */
public class JdbcUtils {

    //在创建连接池时，这个对象就会自动加载配置文件，不用我们来指定
    //采用饿汉式，在程序启动或单例模式类被加载的时候，单例模式实例就已经被创建。（线程安全）
    @SuppressWarnings("static-access")
    private static DataSource dataSource = new DataSourceUtil().getInstance();
    
    /*
     * 原理：
     * 当conn为null时代表没有事务
     * conn不为null时表示有事务
     * 当开始事务时需要给他赋值
     * 当结束事务时需要给他赋值为null
     * 并且在开启事务时，保证dao的多个方法共享一个Connection
     */
    //保证全程使用的是同一个事务，确保安全性,它是事务专用连接！
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    
    
    /**
     * 使用连接池返回一个连接对象,dao使用本方法来获取连接
     * @zclong
     * @2017年7月27日
     * @ReturnType: Connection
     * @return
     * @throws SQLException
     * @throws IOException 
     */
    public static Connection getConnection() throws SQLException {
        
        /*
         * 如果有事务，返回当前事务的conn
         * 如果没有事务，通过连接池返回新的conn
         */
        Connection conn = tl.get();//获得当前线程的事务连接
        // 当con不等于null，说明已经调用过beginTransaction()，表示开启了事务！
        if(conn != null) return conn;//如果conn不为空，则使用同一个连接，不新建连接
        return dataSource.getConnection();
    }
    
    /**
     * 返回连接池对象
     * @zclong
     * @2017年7月27日
     * @ReturnType: DataSource
     * @return
     * @throws Exception 
     */
    public static DataSource getDatasource() throws Exception {
        
        return dataSource;
    }
    
    /**
     * 开启事务
     * 1. 获取一个Connection，设置它的setAutoComnmit(false)
     * 2. 还要保证dao中使用的连接是我们刚刚创建的！
     * --------------
     * 1. 创建一个Connection，设置为手动提交
     * 2. 把这个Connection给dao用！
     * 3. 还要让commitTransaction或rollbackTransaction可以获取到！
     * @zclong
     * @2017年7月28日
     * @ReturnType: void
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection conn = tl.get();  //获取当前线程的事务连接
        if(conn != null) throw new SQLException("已经开启了事务，不能重复开启！");   //若conn不为null，说明开启了事务，否则手动开启事务
        conn = dataSource.getConnection();  //给con赋值，表示开启了事务
        conn.setAutoCommit(false);  //设置为手动提交
        tl.set(conn);  //把当前事务连接添加到线程tl中，保存起来！
    }
    
    /**
     * 提交事务：获取beginTransaction提供的Connection，然后调用commit方法
     * @zclong
     * @2017年7月28日
     * @ReturnType: void
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        Connection conn = tl.get(); //获取当前线程的专用连接
        if(conn == null) throw new SQLException("没有开启事务，不能提交");
        conn.commit();  //开启事务
        conn.close();  //关闭事务（关闭连接）
        // 把它设置为null，表示事务已经结束了！下次再去调用getConnection()返回的就不是con了
        conn = null;  //表示事务结束
        tl.remove();;  //关闭线程，将线程回收，防止内存泄漏
    }
    
    /**
     * 事务回滚：获取beginTransaction提供的Connection，然后调用rollback方法
     * @zclong
     * @2017年7月28日
     * @ReturnType: void
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        Connection conn = tl.get();  //获取当前线程的事务连接
        if(conn == null) throw new SQLException("没有开启事务，不能回滚");
        conn.rollback();  //事务回滚
        conn.close(); //关闭连接
        conn = null;  //表示事务结束
        tl.remove();  //从tl中移除连接，关闭线程，将线程回收，防止内存泄漏
    }
    
    /**
     * 释放Connection：
     * 判断它是不是事务专用，如果是，就不关闭！
     * 如果不是事务专用，那么就要关闭！
     * @zclong
     * @2017年7月28日
     * @ReturnType: void
     * @param connection
     * @throws SQLException
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        Connection conn = tl.get();  //获取当前线程的事务连接
        // 如果con == null，说明现在没有事务，那么connection一定不是事务专用的！
        if(conn == null) connection.close();
        // 如果con != null，说明有事务，那么需要判断参数连接是否与con相等，若不等，说明参数连接不是事务专用连接
        if(connection != conn) { //如果参数连接，与当前事务连接不同，说明这个连接不是当前事务，可以关闭！
            if(connection != null && !connection.isClosed()) {  //如果参数连接没有关闭，则关闭它
                connection.close();
            }
        }
    }
}
