package com.vfoprojects.apilista.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.vfoprojects.apilista.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Api Lista")
	            .description("Api de cadastro de itens numa lista de compras")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Alexandre De Alves Lima", "", ""))
	            .build();
	}


}
