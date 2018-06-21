package fr.epita.quiz.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
@EnableWebMvc
@ComponentScan(basePackages = "fr.epita.quiz.api")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	
}