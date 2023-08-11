## 介绍
 + zhul-sod-cis-项目框架-代码生成器
 
## 版本历史
 + 1.0.0 初始版本
 
## 如何使用

 ### 1.修改数据库配置
 + [application.properties](src/main/resources/application.properties)
 
 ```
sp.url=jdbc:mysql://127.0.0.1:3306/xxxxxx?useUnicode=true&serverTimezone=UTC&characterEncoding=utf-8&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull&&useSSL=false
sp.username=xxxxxx
sp.password=xxxxxx
 ```

 ### 2.应用启动
   + [代码自动生成](src/main/java/com/zhul/sod/cis/generator/Client.java)