package com.zhul.sod.cis.generator.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanglikai on 2020/3/19.
 */
public class AutoGeneratorConfig {

  private AutoGeneratorProperties properties;

  public AutoGeneratorConfig(AutoGeneratorProperties properties) {
    this.properties = properties;
  }

  public DataSourceConfig createDataSourceConfig() {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setUrl(properties.getUrl());
    dataSourceConfig.setDriverName(properties.getDriverClassName());
    dataSourceConfig.setUsername(properties.getUsername());
    dataSourceConfig.setPassword(properties.getPassword());

    return dataSourceConfig;
  }

  public GlobalConfig createGlobalConfigToDao() {
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setFileOverride(true);
    globalConfig.setOpen(false);
    globalConfig.setEnableCache(false);
    globalConfig.setAuthor(properties.getAuthor());
    globalConfig.setKotlin(false);
    globalConfig.setActiveRecord(false);
    globalConfig.setBaseResultMap(false);
    globalConfig.setBaseColumnList(false);
    globalConfig.setMapperName("%sMapper");
    globalConfig.setServiceName("I%sRepository");
    globalConfig.setServiceImplName("%sRepositoryImpl");
    globalConfig.setIdType(IdType.AUTO);

    return globalConfig;
  }

  public PackageConfig createPackageConfigToDao() {
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setParent("com.zhul.sod.cis.dao");
    packageConfig.setEntity("model.entity");
    packageConfig.setMapper("mapper");
    packageConfig.setService("repository");
    packageConfig.setServiceImpl("repository.impl");

    return packageConfig;
  }

  public StrategyConfig createStrategyConfig() {
    StrategyConfig strategy = new StrategyConfig();
    strategy.setCapitalMode(false);
    strategy.setSkipView(true);
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setTablePrefix("");
    strategy.setFieldPrefix("");
    strategy.setSuperEntityClass("com.zhul.cloud.common.model.GeneralDO");
    strategy.setSuperEntityColumns("create_time", "create_by", "update_time", "update_by");
    strategy.setSuperMapperClass(ConstVal.SUPER_MAPPER_CLASS);
    strategy.setSuperServiceClass(ConstVal.SUPER_SERVICE_CLASS);
    strategy.setSuperServiceImplClass(ConstVal.SUPER_SERVICE_IMPL_CLASS);
    strategy.setSuperControllerClass("");
    strategy.setInclude(properties.getIncludeTables().split(","));
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setEntityColumnConstant(true);
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setEntityTableFieldAnnotationEnable(true);

    return strategy;
  }

  public InjectionConfig createInjectionConfigToDao() {
    String projectPath = System.getProperty("user.dir");

    String templatePath4Entity = "/templates/SpEntity.java.vm";
    String templatePath4Mapper = "/templates/SpMapper.java.vm";
    String templatePath4Repository = "/templates/SpRepository.java.vm";
    String templatePath4RepositoryImpl = "/templates/SpRepositoryImpl.java.vm";

    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();

    // 自定义配置会被优先输出
    focList.add(new FileOutConfig(templatePath4Entity) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        return projectPath + "/zhul-sod-cis-dao/src/main/java" + "/com/zhul/sod/cis/dao/model/entity/"
            + tableInfo.getEntityName() + "DO.java";
      }
    });

    focList.add(new FileOutConfig(templatePath4Mapper) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        return projectPath + "/zhul-sod-cis-dao/src/main/java" + "/com/zhul/sod/cis/dao/mapper/"
            + tableInfo.getEntityName() + "Mapper.java";
      }
    });

    focList.add(new FileOutConfig(templatePath4Repository) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        return projectPath + "/zhul-sod-cis-dao/src/main/java" + "/com/zhul/sod/cis/dao/repository/"
            + "I" + tableInfo.getEntityName() + "Repository.java";
      }
    });

    focList.add(new FileOutConfig(templatePath4RepositoryImpl) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        return projectPath + "/zhul-sod-cis-dao/src/main/java"
            + "/com/zhul/sod/cis/dao/repository/impl/"
            + tableInfo.getEntityName() + "RepositoryImpl.java";
      }
    });

    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {
        // to do nothing
      }
    };

    cfg.setFileCreate(new IFileCreate() {
      @Override
      public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
        if (fileType == FileType.OTHER) {
          return true;
        }

        return false;
      }
    });
    cfg.setFileOutConfigList(focList);

    return cfg;
  }
}
