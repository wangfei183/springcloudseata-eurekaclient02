package com.example.springcloudseataeurekaclient03.mybatisplusutils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 王飞
 * @Date: 2020/07/17/13:45
 * @Description:
 */
// 此处使用的默认的模板
public class MBGTest {
    public static void main(String[] args) {
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setActiveRecord(true)	// 是否支持ActiveRecord
                .setEnableCache(false)		// 是否开启二级缓存
                .setAuthor("王飞") 			// 设置作者
                .setOutputDir(projectPath + "/src/main/java") // 生成路径(相对路径)
//                .setOutputDir("C:\\Users\\EDZ\\Desktop\\生成代码文件") // 生成路径(绝对路径)
                .setFileOverride(false)  	// 文件覆盖
                .setBaseResultMap(true)		// mapper映射文件是否生成BaseResultMap
                .setBaseColumnList(true)	// XML 是否生成BaseColumn
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setServiceName("%sService");	// 设置生成的service接口的名字的首字母是否为I

        // 数据源配置
        DataSourceConfig source = new DataSourceConfig();
        source.setDbType(DbType.MYSQL)					// 设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver")		// 数据库驱动
                .setUrl("jdbc:mysql://localhost:3306/seata_award?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Hongkong")	// 数据库地址
                .setUsername("root")						// 用户名
                .setPassword("123456");						// 密码

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true) 		//全局大写命名
                //.setDbColumnUnderline(true)		// 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)	// 数据库表映射到实体的命名策略
//                .setTablePrefix("tbl_")				// 表前缀
                .setInclude("award"); 		// 生成的表

        // 包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.springcloudseataeurekaclient03") 	// 所有包的父包
                .setEntity("bean")				// 实体类包
                .setMapper("mapper")			// mapper接口
                .setXml("mapper")				// xml文件
                .setService("service")			// service文件
                .setServiceImpl("service.impl")	// serviceImpl文件
                .setController("controller");	// controller层的包

        // 整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(source)
                .setPackageInfo(packageConfig)
                .setStrategy(strategy);

        // 执行代码生成器
        autoGenerator.execute();
    }
}
