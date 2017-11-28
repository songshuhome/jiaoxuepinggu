package cn.edu.jxau.utils.druip;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * DataSourceUtil
 * @author zclong 2017年10月30日
 */
public class DataSourceUtil {

    private static String configFile = "dbconfig.properties";
    private static Properties config;
    private static DataSource dataSource;

    //会在类被加载的时候执行且仅会被执行一次，一般用来初始化静态变量和调用静态方法
    //因为在虚拟机的生命周期中一个类只被加载一次；又因为static{}是伴随类加载执行的，所以，不管你new多少次对象实例，static{}都只执行一次
    static {
        DataSourceUtil.parser();
    }

    public static DataSource getInstance() {

        if (dataSource == null) {
            synchronized (DataSourceUtil.class) {
                if (dataSource == null) {
                    try {
                        dataSource = DruidDataSourceFactory.createDataSource(config);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return dataSource;
    }

    /**
     * 加載連接池配置文件
     * @zclong
     * @2017年10月30日
     * @ReturnType: Properties
     * @return
     */
    private static Properties parser() {
        //解析連接池配置文件
        InputStream in = null;
        URL url = DataSourceUtil.class.getClassLoader().getResource(configFile);
        try {
            in = url.openStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        config = new Properties();
        try {
            config.load(new InputStreamReader(in, "utf-8"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return config;
    }
}
