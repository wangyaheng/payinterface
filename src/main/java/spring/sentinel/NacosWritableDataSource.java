//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package spring.sentinel;

import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.lefu.commons.utils.lang.JsonUtils;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * nacos写数据源 往nacos写数据
 * @param <T>
 */
@Component
public class NacosWritableDataSource<T> implements WritableDataSource<T> {



    @Override
    public void write(T value) throws Exception {
        String dataJson = JsonUtils.toJsonString(value);
        // sentinel的流控规则改变保存到nacos中
        // 初始化配置服务，控制台通过示例代码自动获取下面参数
        String serverAddr = "134.175.237.28:8848";
        String dataId = "payinterface";
        String group = "DEFAULE_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        boolean isPublishOk = configService.publishConfig(dataId, group, dataJson);

    }
    @Override
    public void close() throws Exception {
    }
}
