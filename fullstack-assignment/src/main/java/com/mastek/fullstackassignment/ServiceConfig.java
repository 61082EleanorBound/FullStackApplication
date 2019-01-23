package com.mastek.fullstackassignment;

import org.apache.catalina.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component//managed by Spring
public class ServiceConfig extends ResourceConfig{
	
	public ServiceConfig() {
		register(CORSFilter.class);
		register(TrainingAccessAPI.class);
		register(ParticipantAccessAPI.class);
	}

}
