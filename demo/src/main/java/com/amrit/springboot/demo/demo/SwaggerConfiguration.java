/**
 * 
 */
package com.amrit.springboot.demo.demo;

//import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author amrit
 *
 */
//Configure
@Configuration
@EnableSwagger2
//EnableSwagegr
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	//Bean - Docket
	//Configure Documentantion type for swagger
	// For all apis

}
