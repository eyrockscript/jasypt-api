package com.jasypt.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	Optional<BuildProperties> build;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiEndPointsInfo())
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.jasypt.api.controller"))
				.paths(PathSelectors.regex("(/.*)"))
				.build()
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true);
	}

	private ApiInfo apiEndPointsInfo() {
		String version = "1.0.0";
		
		if (build.isPresent())
			version = build.get().getVersion();
		
		return new ApiInfoBuilder()
				.title( serviceName )
				.description("REST API")
				.contact(new Contact("Eliud Trejo", "", "dev.eliud.trejo@gmail.com"))
				.version(version).build();
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().docExpansion(DocExpansion.LIST).build();
	}
}