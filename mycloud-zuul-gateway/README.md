zuul是整个微服务的门面，所有的外部客户端访问都需要经过它来进行调度与过滤。

#注意事项：
1、zuul目前对springboot2.1.2支持并不好，降低springboot版本为2.0.7.RELEASE
2、需要修改数据库连接驱动的配置com.mysql.cj.jdbc.Driver改为com.mysql.jdbc.Driver

#访问路径：
1、未加路由前：
正常访问用户服务：http://localhost:8090/users/get/1 
使用zuul代理访问用户服务：http://localhost:9501/microcloud-provider-users/users/get/1

2、增加路由配置：
http://localhost:9501/users-proxy/users/get/1 