package org.example.server.config;

//import org.example.server.service.SensorService;
//import org.example.server.service.SensorServiceImpl;
import org.example.server.service.ScannerCountyService;
import org.example.server.service.ScannerCountyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
//@PropertySources({@PropertySource(value = "classpath:local/db.properties"),
//})
public class AppConfig {
//  @Bean
//  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//    return new PropertySourcesPlaceholderConfigurer();
//  }
//
@Bean
RestTemplate restTemplate() {
  return new RestTemplate();
}
  @Bean
  public static ScannerCountyService scannerCountyService() {
    return new ScannerCountyServiceImpl();
  }
}