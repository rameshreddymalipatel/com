

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @version 1.0.0
 */
@Configuration
@ComponentScan(basePackages = { "com.incture.cherrywork" })

	}
	@Bean
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(regex("/.*")).build().apiInfo(metaData());
	}
	@Override
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	}

		return new ApiInfoBuilder().title("com Repository API").description("\"com Repository API\"")
				.contact(new Contact("com", null, "ramesh@incture.com")).build();
}
