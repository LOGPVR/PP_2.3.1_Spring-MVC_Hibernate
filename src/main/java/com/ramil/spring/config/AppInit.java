package com.ramil.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Зануляем корневой контекст, чтобы избежать дублирования бинов базы данных!
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Передаем обе конфигурации в один общий Servlet-контекст
        return new Class<?>[]{AppConfig.class, WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
