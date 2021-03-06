package com.chuhui.chat.web.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.chuhui.chat.framework.constant.Contants.customTimeFormat2;
import static com.chuhui.chat.framework.constant.Contants.formatCurrentTime;

/**
 * SpringWebConfig
 *
 * @author: cyzi
 * @Date: 2019/10/17 0017
 * @Description:
 */
@Configuration
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

        System.err.println("invoke method addResourceHandlers"+formatCurrentTime(customTimeFormat2));

        /**
         * 将一切静态资源,全部放过去
         */
        registry.addResourceHandler("images/**").addResourceLocations("/images/").setCachePeriod(-1);
        registry.addResourceHandler("css/**").addResourceLocations("/css/").setCachePeriod(-1);
        registry.addResourceHandler("js/**").addResourceLocations("/js/").setCachePeriod(-1);
        registry.addResourceHandler("fonts/**").addResourceLocations("/fonts/").setCachePeriod(-1);
        registry.addResourceHandler("layui/**").addResourceLocations("/layui/").setCachePeriod(-1);
        registry.addResourceHandler("webjars/**").addResourceLocations("/webjars/").setCachePeriod(-1);
        // html 需要经过视图解析器, 才能识别里面的东西
        registry.addResourceHandler("*.html").addResourceLocations("/WEB-INF/chathtml/").setCachePeriod(-1);
    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        /**
         * 添加FastJson 解析器
         * 从这里
         * https://docs.spring.io/spring/docs/5.1.10.RELEASE/spring-framework-reference/web.html#mvc-config-message-converters
         * 抄来的
         */

        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        config.setCharset(Charset.forName("UTF-8"));

        // json字符串无法转换
        //
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFastJsonConfig(config);


        // 添加支持的类型
        // TODO 这样做太low
        // 准备写个公共的方法
        // https://yq.aliyun.com/articles/614457
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        converter.setSupportedMediaTypes(supportedMediaTypes);

        converters.add(converter);
        converters.add(new FormHttpMessageConverter());

    }

    //
//
//    /**
//     * 启用Thymeleaf引擎
//     * 需要注册三个bean
//     * 直接去这里抄 https://www.thymeleaf.org/documentation.html
//     */
//
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setContentType("text/html;charset=utf-8");
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setRedirectContextRelative(true);
        return viewResolver;
    }

    //
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.context);
        templateResolver.setPrefix("/WEB-INF/chathtml/");
        templateResolver.setSuffix(".html");
        /**
         * 解决js端document.write()中文乱码的问题
         * https://blog.csdn.net/weishenhong/article/details/52074992
         */
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    //
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


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        System.err.println("invoke method addInterceptors "+formatCurrentTime(customTimeFormat2));
        InterceptorRegistration registration = registry.addInterceptor(new ChuHuiChatHandlerInterceptor());

        // 总结一下,这一点很好..
        // 知道了其内部原理
        //
        registration.excludePathPatterns("/**/{filename:\\w+}.html", "/**/{filename:\\w.+}.css","/**/{filename:\\w.+}.js","/**/{filename:\\w.+}.map");


    }


}
