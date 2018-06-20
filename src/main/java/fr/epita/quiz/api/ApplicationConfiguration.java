package fr.epita.quiz.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@ImportResource({"classpath*:applicationContext.xml"})
@EnableWebMvc
@ComponentScan(basePackages = "fr.epita.quiz.api")
public class ApplicationConfiguration {
}