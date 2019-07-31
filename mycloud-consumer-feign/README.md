之前调用服务提供方的接口是通过RestTemplate，需要知道提供方的url及参数，并转换成需要的对象 ，
List list = restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,new HttpEntity(httpHeaders), List.class).getBody();

可以发现所有的数据调用和转换都是由用户直接来完成的，我们可能不想直接访问Rest接口，如果转换回来的直接是对象而不需要直接使用RestTemplate进行转换就好了，这个时候就需要使用Feign了。

feign的操作其实需要ribbon的支持。

本模块调用的服务提供方的接口在mycloud-service模块中提供。