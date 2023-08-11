package com.zhul.sod.cis.generator.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Created by yanglikai on 2020/3/19.
 */
@Data
public class AutoGeneratorProperties {

  private String author;

  private String driverClassName;

  private String url;

  private String username;

  private String password;

  private String includeTables;

  public AutoGeneratorProperties() {
    this("application.properties");
  }

  public AutoGeneratorProperties(String path) {
    _init(path);

    _initTables();
  }

  private void _init(String path) {
    try {
      Properties properties = PropertiesLoaderUtils.loadAllProperties(path);

      this.author = properties.getProperty("sp.author", "");
      this.driverClassName = properties.getProperty("sp.driver-class-name", "");
      this.url = properties.getProperty("sp.url", "");
      this.username = properties.getProperty("sp.username", "");
      this.password = properties.getProperty("sp.password", "");
      this.includeTables = properties.getProperty("sp.include-tables", "");
    } catch (IOException e) {
      throw new RuntimeException("properties init failed!");
    }
  }

  private void _initTables() {
    if (StringUtils.isNotBlank(includeTables)) {
      return;
    }

    try {
      Connection connection = DriverManager.getConnection(url, username, password);

      Statement statement = connection.createStatement();

      ResultSet rs = statement.executeQuery(String
          .format("select table_name from information_schema.tables where table_schema='%s'",
              _schema()));

      List<String> tables = new ArrayList<>();
      while (rs.next()) {
        String name = rs.getString("table_name");
        tables.add(name);
      }

      this.includeTables = String.join(",", tables);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private String _schema() {
    if (StringUtils.isNotBlank(url)) {
      String[] splits_0 = url.split("\\?");
      String link = splits_0.length > 0 ? splits_0[0] : "";

      String[] splits_1 = link.split("\\/");
      String schema = splits_1.length > splits_1.length - 1 ? splits_1[splits_1.length - 1] : "";

      return schema;
    }

    return "";
  }
}
