package computer.restart.plan.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName WhiteListConfig
 * @Description 白名单配置
 * @Author hpc
 * @Date 2021/2/17 19:05
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "whitelist")
public class WhiteListConfig {

    private List<String> urls;
}
