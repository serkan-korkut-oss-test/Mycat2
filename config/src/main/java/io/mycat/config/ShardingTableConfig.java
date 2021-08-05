package io.mycat.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@EqualsAndHashCode
public class ShardingTableConfig {
    ShardingBackEndTableInfoConfig partition = new ShardingBackEndTableInfoConfig();
    ShardingFuntion function = new ShardingFuntion();
    String createTableSQL;

    Map<String,ShardingTableConfig> shardingIndexTables = new HashMap<>();

    public ShardingTableConfig(ShardingBackEndTableInfoConfig partition, ShardingFuntion function, String createTableSQL, Map<String, ShardingTableConfig> shardingIndexTables) {
        this.partition = partition;
        this.function = function;
        this.createTableSQL = createTableSQL;
        this.shardingIndexTables = shardingIndexTables;
    }

    public ShardingTableConfig() {
    }

    public void setShardingIndexTables(Map<String, ShardingTableConfig> shardingIndexTables) {
        this.shardingIndexTables = shardingIndexTables;
    }
}