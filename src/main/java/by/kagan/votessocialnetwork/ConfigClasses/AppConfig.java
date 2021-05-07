package by.kagan.votessocialnetwork.ConfigClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("by.kagan.votessocialnetwork")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;
    @Autowired
    public AppConfig(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver()
    {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(applicationContext);
        springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
        springResourceTemplateResolver.setSuffix(".html");
        return springResourceTemplateResolver;
    }
    @Bean
    public SpringTemplateEngine springTemplateEngine()
    {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry)
    {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        viewResolverRegistry.viewResolver(thymeleafViewResolver);
    }
}

