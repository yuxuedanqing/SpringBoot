## Spring-Boot-Starter-Cache

### 注解

#### 1.@EnableCaching

开启缓存功能，一般放在启动类上

#### 2.@CacheConfig

当我们需要缓存的地方越来越多，你可以使用`@CacheConfig(cacheNames = {"cacheName"})`注解在 class 之上来统一指定 value 的值，这时可
省略 value ，如果你在你的方法依旧写上了 value ，那么依然以方法的 value 值为准。

#### 3.@Cacheable

根据方法对其返回结果进行缓存，下次请求时，如果缓存存在，则直接读取缓存数据返回；如果缓存不存在，则执行方法，并把返回的结果存入缓存中。
一般用在查询方法上。 查看源码，属性值如下：

|--属性--|--方法--|