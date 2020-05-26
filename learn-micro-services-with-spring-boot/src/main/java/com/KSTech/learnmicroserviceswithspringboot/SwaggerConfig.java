package com.KSTech.learnmicroserviceswithspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Configuration means when project executes, This configuration will be load and do the dependency injection
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Rest API", "http://apache.org/", "kamar0786@gmail.com");
    private static final List<VendorExtension> vendorExtensions = new ArrayList<>();
    public  static final ApiInfo DEFAULT_INFO = new ApiInfo("Awesome API", "This is the set of api are used for developing the social media app", "V 0.0.1", "http://apache.org/", DEFAULT_CONTACT, "Apache 2", "http://apache.org/", vendorExtensions);

    @Bean
    public  Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_INFO);
        //.select().apis(RequestHandlerSelectors.basePackage("com.KSTech.learnmicroserviceswithspringboot")).build();
    }
}
