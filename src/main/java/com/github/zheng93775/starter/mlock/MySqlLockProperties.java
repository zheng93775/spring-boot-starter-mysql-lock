package com.github.zheng93775.starter.mlock;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zheng93775 on 2019/6/13.
 */
@ConfigurationProperties(prefix = "mysql-lock")
public class MysqlLockProperties {
    /**
     * 为false则不启用mysql-lock，为true或者未填写则默认开启
     */
    private Boolean enable;
    /**
     * 配置关联的dataSource Bean
     */
    private String dataSourceBeanName;
    /**
     * 数据库连接地址
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;
    /**
     * 分布式锁表名
     */
    private String tableName;
    /**
     * lock_key表字段的最大长度
     */
    private Integer lockKeyMaxLength;
    /**
     * 锁的过期时间，单位为秒
     */
    private Integer expireSeconds;
    /**
     * 阻塞式地获取锁时，重复尝试的间隔毫秒数
     */
    private Long tryLockInterval;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getDataSourceBeanName() {
        return dataSourceBeanName;
    }

    public void setDataSourceBeanName(String dataSourceBeanName) {
        this.dataSourceBeanName = dataSourceBeanName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getLockKeyMaxLength() {
        return lockKeyMaxLength;
    }

    public void setLockKeyMaxLength(Integer lockKeyMaxLength) {
        this.lockKeyMaxLength = lockKeyMaxLength;
    }

    public Integer getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public Long getTryLockInterval() {
        return tryLockInterval;
    }

    public void setTryLockInterval(Long tryLockInterval) {
        this.tryLockInterval = tryLockInterval;
    }
}
