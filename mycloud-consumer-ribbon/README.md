ribbon负责负载均衡，默认策略是轮询方式，可以修改随机或其他方式；

如果要指定某个服务使用特定的负载策略，记得将该配置放到spring扫描不到的位置（参考com.sg.ribbon包目录）。

不依赖eureka，直接使用ribbon的包；（eureka-client中默认自带了ribbon的包）