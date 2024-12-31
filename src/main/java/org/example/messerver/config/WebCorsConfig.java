package org.example.messerver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 27542
 */
@Configuration
public class WebCorsConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 网络地址映射实际地址
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:C:/external/project/java/music/img/");
        registry.addResourceHandler("/song/**")
                .addResourceLocations("file:C:/external/project/java/music/song/");
    }

    /**
     * 跨域配置
     * 1.后台url路径匹配
     * 2.请求的来源地址规则
     * 3.请求头信息（Headers: token 验证信息）
     * 4.设置请求的方式
     * 5.是否允许携带 cookie 信息
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true).maxAge(6000);
    }
}
