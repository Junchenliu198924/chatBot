package org.bocim.config;

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

    private  String    openaiApiKey     ;

    private  String    openaiMode ;

    private   String   apiWebsite  ;


    public String getOpenaiApiKey() {
        return openaiApiKey;
    }

    public void setOpenaiApiKey(String openaiApiKey) {
        this.openaiApiKey = openaiApiKey;
    }

    public String getOpenaiMode() {
        return openaiMode;
    }

    public void setOpenaiMode(String openaiMode) {
        this.openaiMode = openaiMode;
    }

    public String getApiWebsite() {
        return apiWebsite;
    }

    public void setApiWebsite(String apiWebsite) {
        this.apiWebsite = apiWebsite;
    }
}
