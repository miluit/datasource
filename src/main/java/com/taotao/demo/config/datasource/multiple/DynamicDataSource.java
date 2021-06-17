package com.taotao.demo.config.datasource.multiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    DataSource dataSource;

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        this.dataSource = defaultTargetDataSource;
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        // afterPropertiesSet()方法调用时用来将targetDataSources的属性写入resolvedDataSources中的
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DynamicDataSourceContextHolder.getDataSourceName();
        if (logger.isInfoEnabled()) {
            if (null != dataSourceName) {
                logger.info("切换到{}数据源", dataSourceName);
            } else {
                logger.info("使用默认数据源");
            }
        }
        return dataSourceName;
    }
}
