# MySQL-based distributed lock

## Introduction 简介

[mysql-lock](https://github.com/zheng93775/mysql-lock/)集成SpringBoot的自动配置版本。零配置，友好封装，易于使用。

## Out Of The Box 开箱即用
```
<dependency>
    <groupId>com.github.zheng93775</groupId>
    <artifactId>spring-boot-starter-mysql-lock</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.40</version>
</dependency>
```
零配置（Bean容器里存在唯一DataSource Bean的情况下）
```
MLock mLock = new MLock("DailyJob");
try {
    if (mLock.tryLock()) {
        // TODO add your code here
    }
} finally {
    mLock.unlock();
}
```

## 配置项

可以在application.yml里进行如下配置，根据业务场景灵活地使用MLock

```
mysql-lock:
  enable:               # 开关，true则开启分布式锁自动配置，false则关闭此功能。未配置此属性等同于true，默认开启
  dataSourceBeanName:   # 多数据源的场景下，此配置项决定分布式锁使用哪个数据源
  url:                  # 数据库连接地址
  username:             # 数据库用户名
  password:             # 数据库密码
  tableName:            # 分布式锁表名，未配置的默认值为tb_distributed_lock
  lockKeyMaxLength:     # lock_key表字段的最大长度，默认值为64
  expireSeconds:        # 锁的过期时间，单位为秒，默认值为60
  tryLockInterval:      # 阻塞式地获取锁时，重复尝试的间隔毫秒数，默认值为1000毫秒
```

数据源的优先级：mysql-lock.url -> mysql-lock.dataSourceBeanName -> Bean容器里的唯一DataSource

以上配置均是可选配置，未配置时采用默认方式启动