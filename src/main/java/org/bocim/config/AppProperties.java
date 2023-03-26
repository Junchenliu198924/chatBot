package org.bocim.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author     ：ljc
 * @ Date       ：Created in 08:02 2023/3/26
 * @ Description：
 */
@Configuration
@ConfigurationProperties(prefix = "bocim")
public class AppProperties {
    @Getter
    @Setter
    private  String    openaiApiKey     ;
    @Getter
    @Setter
    private  String    openaiMode ;
    @Getter
    @Setter
    private   String   apiWebsite  ;
    
}
