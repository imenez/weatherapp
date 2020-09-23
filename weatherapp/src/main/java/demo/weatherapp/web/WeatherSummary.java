package demo.weatherapp.web;

import demo.weatherapp.ows.Weather;

public class WeatherSummary {
	
	private final String country;
	
	private final String city;
	
	private final Integer code;
	
	private final String icon;
	
	private final double temperature;
	
	WeatherSummary(String country, String city, Weather weather){
		this.country = country;
		this.city = city;
		this.code = weather.getWeatherId();
		this.icon = weather.getWeatherIcon();
		this.temperature = weather.getTemperature();
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public Integer getCode() {
		return code;
	}

	public String getIcon() {
		return icon;
	}
	
	public String getFahrenheitTemperature() {
		double fahrenheitTemp = (this.temperature * 1.8) - 459.67;
		return String.format("%4.2f", fahrenheitTemp);
	}
	
	public String getCelsiusTemperature() {
		double celsiusTemp = this.temperature - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
	
	

}
