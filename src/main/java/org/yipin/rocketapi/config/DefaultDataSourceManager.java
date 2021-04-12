package org.yipin.rocketapi.config;

import com.github.alenfive.rocketapi.datasource.DataSourceDialect;
import com.github.alenfive.rocketapi.datasource.DataSourceManager;
import com.github.alenfive.rocketapi.datasource.MongoDataSource;
import com.github.alenfive.rocketapi.datasource.MySQLDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tao.qiu01@hand-china.com
 * @version 1.0
 * @date 2021-04-12
 */
@Component
public class DefaultDataSourceManager extends DataSourceManager {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {

        Map<String, DataSourceDialect> dialects = new HashMap<>();
        //通过MongoDataSource的第二个参数为`true`来表示生成的API信息所存储的库，有且仅有一个为true
        dialects.put("mongo",new MongoDataSource(mongoTemplate,true));
        super.setDialectMap(dialects);
    }
}
