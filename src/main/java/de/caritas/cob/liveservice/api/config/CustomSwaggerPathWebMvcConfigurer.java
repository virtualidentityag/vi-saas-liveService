package de.caritas.cob.liveservice.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CustomSwaggerPathWebMvcConfigurer implements WebMvcConfigurer {

  @Value("${springfox.docuPath}")
  private String docuPath;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(docuPath + "/**")
        .addResourceLocations("classpath:/META-INF/resources/");
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("*")
        .allowCredentials(true);
  }
}
