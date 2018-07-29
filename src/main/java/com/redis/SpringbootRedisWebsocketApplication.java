package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringbootRedisWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisWebsocketApplication.class, args);
	}
}
