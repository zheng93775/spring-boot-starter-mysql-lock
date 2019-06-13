package com.github.zheng93775.starter.mlock;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by zhengjh on 2019/6/13.
 */
@ConfigurationProperties(prefix = "mysql-lock")
public class MysqlLockProperties {
    private Boolean enable;
    private String dataSourceBeanName;
    private String url;
    private String username;
    private String password;
    private String tableName;
    private Integer lockKeyMaxLength;
    private Integer expireSeconds;
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
