//package com.electronics.eureka.swagger;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//public class PropertyResourceProvider implements SwaggerResourcesProvider {
//	 // application.yml props get wired into this config
//    @Autowired
//    private SwaggerServicesConfig config;
//
//    @Override
//	public
//    List get() {
//        config.services.collect { svc ->
//            new SwaggerResource(
//                    name: svc.name,
//                    location: svc.url,
//                    swaggerVersion: svc.version
//            )
//        }
//    }
//}
