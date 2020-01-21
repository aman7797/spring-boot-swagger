package com.electronic.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	@RequestMapping("/getURL/{applicationName}")
	public String getURL(@PathVariable String applicationName) {
		String url = "";
		for (ServiceInstance item : this.discoveryClient.getInstances(applicationName)) {
			url = item.getUri().getHost() + item.getUri().getPort();
			System.out.println("URL - " + item.getUri());
		}
		return url;
	}
}
