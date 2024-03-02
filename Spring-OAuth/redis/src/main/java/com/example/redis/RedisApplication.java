package com.example.redis;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisApplication {
	
//	public static class Cat {}
//	Custom Redis Configuration
//	@Bean
//	public RedisTemplate<String, Cat> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		
//		RedisSerializer<Cat> value = new Jackson2JsonRedisSerializer<Cat>(Cat.class);
//		
//		RedisSerializer<String> key = new StringRedisSerializer();
//		
//		RedisTemplate<String, Cat> template = new RedisTemplate<>();
//		
//		template.setConnectionFactory(redisConnectionFactory);
//		
//		template.setKeySerializer(key);
//		
//		template.setValueSerializer(value);
//		
//		template.setHashValueSerializer(value);
//		
//		template.setHashKeySerializer(key);
//		
//		return template;
//	}
	
	private ApplicationRunner titleRunner(String title, ApplicationRunner rr) {
		return args -> {
			rr.run(args);
		};
	}
	
	@Bean
	ApplicationRunner geography (RedisTemplate<String, String> rt) {
		
		return titleRunner("geography", args -> {
			
			GeoOperations<String,String> geo = rt.opsForGeo();
			
			geo.add("Sicily", new Point(13.361389, 38.1155556), "Arigento");
			
			geo.add("Sicily", new Point(15.087269, 37.502669), "Catenia");
			
			geo.add("Sicily", new Point(13.583333, 37.316667), "Palerno");
			
			Circle circle = new Circle(new Point(13.583333, 37.316667), new Distance(100, RedisGeoCommands.DistanceUnit.KILOMETERS));
			
			GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = geo.radius("Sicily", circle);
			
			geoResults
					.getContent()
					.forEach(System.out::println);
			
		});
	}

	public static void main(String[] args) { SpringApplication.run(RedisApplication.class, args); }

}
