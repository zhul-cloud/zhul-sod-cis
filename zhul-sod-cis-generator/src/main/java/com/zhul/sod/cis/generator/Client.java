package com.zhul.sod.cis.generator;


import com.zhul.sod.cis.generator.core.AutoGeneratorConfig;
import com.zhul.sod.cis.generator.core.AutoGeneratorManager;
import com.zhul.sod.cis.generator.core.AutoGeneratorProperties;

/**
 * Created by yanglikai on 2020/3/19.
 */
public class Client {

  public static void main(String[] args) {
    System.out.println("==========================准备生成文件...==========================");

    // 自动生成属性
    AutoGeneratorProperties properties = new AutoGeneratorProperties();

    // 自动生成配置
    AutoGeneratorConfig config = new AutoGeneratorConfig(properties);

    // 自动生成管理
    AutoGeneratorManager manager = new AutoGeneratorManager(config);

    // 代码生成
    manager.buildToDao();

    System.out.println("==========================文件生成完成!!!==========================");
  }
}
