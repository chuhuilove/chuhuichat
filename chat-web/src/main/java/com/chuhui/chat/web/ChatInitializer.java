package com.chuhui.chat.web;

import com.chuhui.chat.web.config.AppConfig;
import com.chuhui.chat.web.config.DispatcherConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * ChatInitializer
 * <p>
 * 整个应用的入口程序
 *
 * @author: cyzi
 * @Date: 2019/10/16 0016
 * @Description: chat 应用的入口程序
 */
public class ChatInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletCxt) {



        AnnotationConfigWebApplicationContext rootWebApplicationContext = new AnnotationConfigWebApplicationContext();
        rootWebApplicationContext.register(AppConfig.class);
        // 添加上下文加载监听器
        servletCxt.addListener(new ContextLoaderListener(rootWebApplicationContext));



//        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//        // Register and map the dispatcher servlet
//        dispatcherContext.register(DispatcherConfig.class);
//        dispatcherContext.refresh();

        /**
         * 添加servlet
         */
        ServletRegistration.Dynamic dispatcherServlet =
                servletCxt.addServlet("dispatcherServlet", new DispatcherServlet(rootWebApplicationContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        /**
         * 配置过滤器,编码过滤器
         */
        FilterRegistration.Dynamic encodingFilter =
                servletCxt.addFilter("encodingFilter", CharacterEncodingFilter.class);
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");






    }
}
