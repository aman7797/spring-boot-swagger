package com.electronic.swagger.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Primary
@Configuration
public class SwaggerConfigProvider implements SwaggerResourcesProvider {

	private final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfigProvider.class);

	@Autowired
	private RouteLocator routeLocator;
	
	@Autowired
    private ServletContext servletContext;

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();

		// Add the default swagger resource that correspond to the gateway's own swagger
		// doc
		resources.add(swaggerResource("default", "/v2/api-docs", "2.0"));

		// Add the registered microservices swagger docs as additional swagger resources
		List<Route> routes = routeLocator.getRoutes();
		routes.forEach(route -> {
			LOGGER.info("getId - " + route.getId() + " & path - " + route.getFullPath());
			resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "2.0"));
		});

		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}
