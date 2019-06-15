package com.github.zheng93775.starter.mlock;

import com.github.zheng93775.mlock.CustomizedMLockConfigurator;
import com.github.zheng93775.mlock.DataSourceMLockConfigurator;
import com.github.zheng93775.mlock.MLockConfigurator;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by zheng93775 on 2019/6/13.
 */
@Configuration
@ConditionalOnProperty(value = "mysql-lock.enable", matchIfMissing = true)
@EnableConfigurationProperties(MysqlLockProperties.class)
@AutoConfigureAfter(name = "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration")
public class MysqlLockAutoConfiguration {

    @Autowired
    private MysqlLockProperties mysqlLockProperties;

    @Autowired(required = false)
    private Map<String, DataSource> dataSourceMap;

    @Bean(initMethod = "configure")
    public MLockConfigurator mLockConfigurator() {
        if (StringUtils.hasLength(mysqlLockProperties.getUrl())) {
            CustomizedMLockConfigurator configurator = new CustomizedMLockConfigurator();
            configurator.setUrl(mysqlLockProperties.getUrl());
            configurator.setUsername(mysqlLockProperties.getUsername());
            configurator.setPassword(mysqlLockProperties.getPassword());
            configurator.setTableName(mysqlLockProperties.getTableName());
            configurator.setLockKeyMaxLength(mysqlLockProperties.getLockKeyMaxLength());
            configurator.setExpireSeconds(mysqlLockProperties.getExpireSeconds());
            configurator.setTryLockInterval(mysqlLockProperties.getTryLockInterval());
            return configurator;
        } else {
            DataSource dataSource = null;
            if (dataSourceMap != null) {
                if (dataSourceMap.size() == 1) {
                    dataSource = dataSourceMap.values().stream().findFirst().get();
                } else {
                    String dataSourceBeanName = mysqlLockProperties.getDataSourceBeanName();
                    if (StringUtils.hasLength(dataSourceBeanName)) {
                        dataSource = dataSourceMap.get(dataSourceBeanName);
                    }
                }
            }
            if (dataSource != null) {
                DataSourceMLockConfigurator configurator = new DataSourceMLockConfigurator();
                configurator.setDataSource(dataSource);
                configurator.setTableName(mysqlLockProperties.getTableName());
                configurator.setLockKeyMaxLength(mysqlLockProperties.getLockKeyMaxLength());
                configurator.setExpireSeconds(mysqlLockProperties.getExpireSeconds());
                configurator.setTryLockInterval(mysqlLockProperties.getTryLockInterval());
                return configurator;
            } else {
                throw new BeanInitializationException("Both mysql-lock.url property and DataSource Bean Not Found");
            }
        }
    }
}
