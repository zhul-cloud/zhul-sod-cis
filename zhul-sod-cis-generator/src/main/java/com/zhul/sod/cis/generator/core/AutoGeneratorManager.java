package com.zhul.sod.cis.generator.core;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * Created by yanglikai on 2020/3/19.
 */
public class AutoGeneratorManager {

  private AutoGeneratorConfig autoGeneratorConfig;

  private DataSourceConfig dataSourceConfig;

  private StrategyConfig strategyConfig;

  public AutoGeneratorManager(AutoGeneratorConfig autoGeneratorConfig) {
    this.autoGeneratorConfig = autoGeneratorConfig;

    _init();
  }

  public void buildToDao() {
    AutoGenerator autoGenerator = new AutoGenerator();
    autoGenerator.setDataSource(dataSourceConfig);
    autoGenerator.setStrategy(strategyConfig);
    autoGenerator.setGlobalConfig(autoGeneratorConfig.createGlobalConfigToDao());
    autoGenerator.setPackageInfo(autoGeneratorConfig.createPackageConfigToDao());
    autoGenerator.setCfg(autoGeneratorConfig.createInjectionConfigToDao());
    autoGenerator.setTemplateEngine(new VelocityTemplateEngine());
    autoGenerator.execute();
  }

  private void _init() {
    this.dataSourceConfig = autoGeneratorConfig.createDataSourceConfig();
    this.strategyConfig = autoGeneratorConfig.createStrategyConfig();
  }
}
