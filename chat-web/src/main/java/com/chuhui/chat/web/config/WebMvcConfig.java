package com.chuhui.chat.web.config;

//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.WebJarsResourceResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.List;

/**
 * SpringWebConfig
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:
 */
@Configuration
//@EnableWebMvc 2019年10月17日15:45:04 在5.1.10 版本中,继承WebMvcConfigurationSupport和添加@EnableWebMvc不能同时启用
@ComponentScan("com.chuhui.chat.web.controller")
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    ApplicationContext context;


//    @Override
//    protected void configureViewResolvers(ViewResolverRegistry registry) {
//
//          // 采用jsp的写法
////        registry.jsp("/WEB-INF/jsp/",".jsp");
//    }


    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        /**
         * 将一切静态资源,全部放过去
         */
        registry.addResourceHandler("images/**").addResourceLocations("/images/");
        registry.addResourceHandler("css/**").addResourceLocations("/css/");
        registry.addResourceHandler("js/**").addResourceLocations("/js/");
        registry.addResourceHandler("fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("webjars/**").addResourceLocations("/webjars/");
    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /**
         * 添加FastJson 解析器
         * 从这里
         * https://docs.spring.io/spring/docs/5.1.10.RELEASE/spring-framework-reference/web.html#mvc-config-message-converters
         * 抄来的
         */
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        converters.add(converter);

    }


    /**
     * 启用Thymeleaf引擎
     * 需要注册三个bean
     * 直接去这里抄 https://www.thymeleaf.org/documentation.html
     */

    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setContentType("text/html;charset=utf-8");
        return viewResolver;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.context);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new ChatHandlerExceptionResolver());
    }

}
