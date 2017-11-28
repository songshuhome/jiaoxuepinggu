package cn.edu.jxau.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 这个类中的方法，自己来处理连接的问题
 * 无需外界传递！　
 * 处理方法：
 *   通过JdbcUtils.getConnection()得到连接！有可能是事务连接，也可能是普通的连接！
 *   JdbcUtils.releaseConnection()完成对连接的释放！如果是普通连接，关闭之！
 * 1. 得到连接
 * 2. 执行父类方法，传递连接对象
 * 3. 释放连接
 * 4. 返回值
 *
 * TxQueryRunner
 * @author zclong 2017年7月28日
 */
public class TxQueryRunner extends QueryRunner{

    /**
     * 批量处理操作，在数据大批量操作（新增、删除等）的情况下可以大幅度提升系统的性能
     * 允许将多个sql语句作为一个单元送至数据库去执行，这样做可以提高操作效率
     * -------------------------------------------------------------
     * batch是批处理。所以需要的参数是一个数组，这个数组第一个参数代表执行的次数，比如下面的5次，第二个参数代表需要的参数个数，下面是3个。
     * 所以就需要创建一个二维数组，把这个二维数组赋值过去。
     * Object[][] params=new Object[5][];
     *   for(int i=0;i<params.length;i++){
     *   params[i]=new Object[]{"tom"+i,"000"+i,i+"@163.com"};
     * }
     * qr.batch("insert into fuser(username,pwd,email) values(?,?,?)", params);
     * 返回一个 数组，这个数组是说明每条命令所影响的行数
     * 具体操作例：http://blog.csdn.net/weisubao/article/details/52575787
     *         http://mousepc.iteye.com/blog/1131462
     */
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /*
         * 1. 得到连接
         * 2. 执行父类方法，传递连接对象
         * 3. 释放连接
         * 4. 返回值
         */
        Connection conn = JdbcUtils.getConnection();
        int[] result = super.batch(conn, sql, params);
        JdbcUtils.releaseConnection(conn);
        return result;
    }
    
    /**
     * 把查询结果封装到ResultSetHandler里面取出
     * BeanHandler：按条件查询（例如根据主键id查询）将结果集中的第一行数据封装到一个对应的JavaBean实例中（用于只查询出一条数据），返回JavaBean对象。例 书写格式：new BeanHandler<User>(User.class)
     * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里（用于查询出多条数据），返回List集合。书写格式：new BeanListHandler<Member>(Member.class)
     * ScalarHandler：单值查询（用于查询某个字段，比如查询某用户的激活状态）返回查询某个字段的值，书写格式：new ScalarHandler()
     * ArrayHandler ： 将查询结果每一行转换为一个数组对象返回,返回一个数组Object[]， 书写格式：new ArrayHandler()
     * ArrayListHandler： 将查询结果的每一行转换为一个Object[]数组，然后装入一个ArrayList集合，返回一个List集合List<Object[]>，  书写格式：new ArrayListHandler()
     * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。 返回一个Map， 书写格式： new MapHandler()
     * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List，返回List<Map<String, Object>>，  书写格式： new MapListHandler()
     * ColumnListHandler：将结果集中某一列的数据存放到List中 ，返回List<Object>，  书写格式： new ColumnListHandler(2)，2：参数表示第几列
     * KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里(List<Map>)，再把这些map再存到一个map里，其key为指定的列。返回Map<Object, Map<String, Object>> ，  书写格式： new KeyedHandler("id")
     */
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }
    
    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        T result = super.query(con, sql, rsh);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, param);
        JdbcUtils.releaseConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtils.getConnection();
        int result = super.update(con, sql, params);
        JdbcUtils.releaseConnection(con);
        return result;
    }
}
