在hystrix里面提供一个Dashboard（仪表盘）的功能，他是一种监控的功能，可以利用它来进行整体服务的监控。 

对应在provider中要配置managment

hystrix监控地址： http://localhost:9001/hystrix 
单个服务监控地址：http://localhost:8080/actuator/hystrix.stream
turbine监控地址：http://localhost:9101/turbine.stream