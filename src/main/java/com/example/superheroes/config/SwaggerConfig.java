package com.example.superheroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The type Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * Api docket.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build();
    }

	/**
	 * Api info api info.
	 *
	 * @return the api info
	 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Sample APIs")
                .description("This page lists all the rest apis for Swagger Sample App.")
                .version("1.0-SNAPSHOT")
                .build();
    }

    /**
	 * Only select apis that matches the given Predicates
	 *
	 * @return the predicate
	 */
    private Predicate<String> paths() {
        // Match all paths except /error
        return Predicates.and(
                PathSelectors.regex("/.*"),
                Predicates.not(PathSelectors.regex("/error.*"))
        );
    }
    
    public void configure(WebSecurity web) {
    	web.ignoring().antMatchers("/swagger-ui.html", "swagger-resources/**");
    }

}
