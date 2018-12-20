package com.liangzhelang.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;


public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.liangzhelang.core";
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = false;
        generateByTables(serviceNameStartWithI, packageName, "language", "type", "sentence","nation", "person", "work");

    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://localhost:3306/note?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("9ol8ik");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setEntityLombokModel(true)
                .setCapitalMode(true)
//                .setDbColumnUnderline(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                //修改替换成你需要的表名，多个表名传数组
                .setInclude(tableNames);
        config
                .setActiveRecord(false)
                .setAuthor("liangzhelang")
                .setOutputDir("D:\\Workspace\\Idea-Directory\\Sentences2.5\\src\\main\\java")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        config.setBaseResultMap(true);
        config.setBaseColumnList(true);
        config.setActiveRecord(false);
        config.setFileOverride(true);
        config.setOpen(false);
//        config.setIdType(IdType.INPUT);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                
            }
        };
        /*List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/mybatis/template/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "C:\\deployment\\IdeaProject\\ecip\\ecip-web\\src\\main\\java\\com\\hgsoft\\ecip\\web\\rbac\\mapper\\" 
                        + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);*/

        new AutoGenerator().setGlobalConfig(config)
                .setCfg(cfg)
//                .setTemplate(tc)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("web.controller")
                                .setXml("mapper")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
