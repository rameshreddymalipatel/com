
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author INC00400 (Ramesh Reddy Malipatel)
 * @version 1.0.0
 * @since 01-Jan-2021
 */
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.incture.cherrywork" })
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

	public SwaggerConfiguration() {
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(regex("/.*")).build().apiInfo(metaData());

	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}


	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("com Repository API").description("\"com Repository API\"")
				.version("1.0.0")
				.contact(new Contact("com", null, "ramesh@incture.com")).build();
	}
}
null
