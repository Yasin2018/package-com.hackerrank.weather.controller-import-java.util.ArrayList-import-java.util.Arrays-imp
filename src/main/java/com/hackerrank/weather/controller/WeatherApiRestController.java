package com.hackerrank.weather.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hackerrank.weather.model.Weather;






@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

	
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private Validator validator;
	
	
	@RequestMapping("/weather")
	@ResponseStatus(HttpStatus.OK)
	public List<Weather> getweathers() {
		List<Weather> weatherList=weatherService.getWeathers();
		
		
			return (List<Weather>) ResponseEntity.ok().build();
		
		
		
		
				
	}
	
	@RequestMapping("/weather/{id}")
	public ResponseEntity<Object> getweather(@PathVariable int weatherId) {
		
        Weather weather=weatherService.getWeather(weatherId); 
		
        if(weather!=null)
			return  ResponseEntity.ok().build();
		else
			return (ResponseEntity<Object>) ResponseEntity.notFound();
			
		
				
	}
	
	
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteweather/{id}")
	public ResponseEntity<Object> deleteweather(@PathVariable int weatherId) {
		
		Weather weather=weatherService.getWeather(weatherId); 
		 if(weather!=null) {
			 weatherService.deleteWeather(weatherId);
			 return  ResponseEntity.noContent().build();
		 }else {
			 return (ResponseEntity<Object>) ResponseEntity.notFound();
		 }
				
		
		
				
	}
		
	
}
