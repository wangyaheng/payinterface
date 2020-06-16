package spring.shardingjdbc;


import com.alibaba.druid.pool.DruidDataSource;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class HelloSharding {

    public static void main(String[] args) throws Exception {

        Map<String, DataSource> dataSourceMap = new HashMap<>();

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://10.10.111.14:3306/promotionfee?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
        dataSource.setUsername("promotionfee");
        dataSource.setPassword("haoshikisses");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceMap.put("ds1", dataSource);
        // 配置order的表规则"fee_frozen_record","ds${1}.fee_frozen_record${0..1}"
        TableRuleConfiguration frozenRecordCfg = new TableRuleConfiguration();
        frozenRecordCfg.setLogicTable("fee_frozen_record");
        frozenRecordCfg.setActualDataNodes("ds${1}.fee_frozen_record${0..1}");
        // 配置分库分表策略
        frozenRecordCfg.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "ds1"));
        frozenRecordCfg.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "fee_frozen_record${id % 2}"));
        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(frozenRecordCfg);

        DataSource shardDataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new HashMap<String, Object>(),new Properties());

        Connection connection = shardDataSource.getConnection();
        String sql ="select * from fee_frozen_record where id = 1";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet executeQuery = ps.executeQuery();
        while(executeQuery.next()){
            System.out.println(executeQuery.getString("consumer_no"));
        }
        System.out.println(connection);


    }
}
