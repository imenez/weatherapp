package demo.weatherapp.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
/*import org.springframework.http.MediaType;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.weatherapp.WeatherAppProperties;
import demo.weatherapp.ows.Weather;
import demo.weatherapp.ows.WeatherForecast;
import demo.weatherapp.ows.WeatherService;

@RestController
@RequestMapping("/api/weather")
/*URI path'e mapping**/
public class WeatherApiRestController {
	
	 
	/* @RequestMapping(value="/hello", produces=MediaType.APPLICATION_XML_VALUE) 
	 gelen datanın xml,json vs dönmesi için */
	
	@Autowired
	WeatherService weatherService;
	
	
	/*Autowired yerine?;
	 * private final WeatherService weatherService;
	 
	private final WeatherAppProperties properties;
	
	
	public WeatherApiRestController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}*/
	
	/*AutoWired WeatherService classını otomatik getiriyor.
	 * Deployment anında build ederken tüm classları kontrol edip, spring bean sayıp ayağa kaldırıyor*/
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
		
	}
	
	
	@RequestMapping("/now/{country}/{city}")
	public Weather getWeather(@PathVariable String country,
			@PathVariable String city, HttpServletResponse response) {
		/* Requestte response code olarak 301 setlendi*/
		response.setStatus(301);
		return this.weatherService.getWeather(country, city);
		
	}
	
	
	@RequestMapping("/weekly/{country}/{city}")
	public WeatherForecast getWeatherForecast(@PathVariable String country,
			@PathVariable String city) {
		return this.weatherService.getWeatherForecast(country, city);
		
	}

}
