package demo.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
/*
 * @ImportResource("appContext.xml") ile daha önce kullanılan xml beanleri applicationContexte
  kullanabilir hale geliyor. 
 */

@EnableConfigurationProperties(WeatherAppProperties.class)

/*WeatherAppProperties.class ı uygulamanın propertieslerini okumamızı sağlayan bir class*/
public class WeatherApp {
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherApp.class);
	}

}
