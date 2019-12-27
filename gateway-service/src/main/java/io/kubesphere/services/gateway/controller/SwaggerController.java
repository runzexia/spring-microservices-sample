package io.kubesphere.services.gateway.controller;


import io.swagger.models.Swagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.util.List;

@Controller
public class SwaggerController {
    private final SwaggerResourcesProvider swaggerResources;

    @Autowired
    public SwaggerController(SwaggerResourcesProvider swaggerResources) {
        this.swaggerResources = swaggerResources;
    }

    @RequestMapping({"/swagger-resources/configuration/security"})
    @ResponseBody
    public ResponseEntity<SecurityConfiguration> securityConfiguration() {
        return ResponseEntity.ok(SecurityConfigurationBuilder.builder().build());
    }

    @RequestMapping({"/swagger-resources/configuration/ui"})
    @ResponseBody
    public ResponseEntity<UiConfiguration> uiConfiguration() {
        return ResponseEntity.ok(UiConfigurationBuilder.builder().build());
    }

    @RequestMapping({"/swagger-resources"})
    @ResponseBody
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return ResponseEntity.ok(this.swaggerResources.get());
    }

}