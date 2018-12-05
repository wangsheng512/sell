package com.wsheng.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: s5
 * @Date: 2018/8/27 21:03
 * @Description:
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    /**
     * 微信公众平台授权url
     */
    public String wechatMpAuthorize;

    /**
     * 微信开放平台授权url
     */
    public String wechatOpenAuthorize;

    /**
     * 点餐系统
     */
    public String sell;
}
