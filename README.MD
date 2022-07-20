## springcloudalibbaba 学习
[参考视频地址](https://www.bilibili.com/video/BV18E411x7eT?p=7&spm_id_from=pageDriver&vd_source=ab0d7f31ecb77d9df82fa8718614ac91)

### 创建多模块
1、先创建一个空的maven项目--> 添加<packaging>pom</packaging> --> 添加相关依赖和插件
2、file-->new->module
3、改pom、写yml、写住启动、写逻辑业务

## idea 配置 service 服务，多模块同时启动
- 1，打开IDEA项目 .idea 下 的workspace.xml
- 2，查找“RunDashboard” 节点, 如果节点没有就直接加下面代码，如果有，就加option节点内容
````
<component name="RunDashboard">
  <option name="configurationTypes">
    <set>
      <option value="SpringBootApplicationConfigurationType" />
    </set>
  </option>
</component>
````

## 8、springboot devtools 热部署
- 1、“File” -> “Settings” -> “Build,Execution,Deplyment” -> “Compiler”，选中打勾 “Build project automatically” 。

- 2、组合键：“Shift+Ctrl+Alt+/” ，选择 “Registry” ，选中打勾 “compiler.automake.allow.when.app.running” 。

- 3、引入jar和配置 <fork>true</fork> ,如果没有该配置，devtools不会生效
````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>

 <plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <fork>true</fork> <!-- 如果没有该配置，devtools不会生效 这个可以放到父类里面 -->
        </configuration>
    </plugin>
</plugins>
````

## 地址映射
修改：C:\Windows\System32\drivers\etc\host 文件 如
````
# 地址映射

127.0.0.1       eureka7001
127.0.0.1       eureka7002
127.0.0.1       eureka7003
````

###FQA
#### 反复创建一个项目，有时候java和resource资源文件就会乱，怎么处理
我直接删除.idea 文件，然后重启idea，感觉就好了
