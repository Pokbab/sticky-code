package test.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

@Configuration
@EnableSwagger2
@Import({BeanValidatorPluginsConfiguration.class})
//public class SwaggerConfig extends WebMvcConfigurerAdapter { // Deplecated ver Spring4
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket consoleApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.groupName("console")
			.select()
			.apis(RequestHandlerSelectors.basePackage("test.interfaces.web"))
			.paths(Predicates.not(PathSelectors.ant("/**/admin/**")))
			.build()
			.useDefaultResponseMessages(false)
			.genericModelSubstitutes(DeferredResult.class)
			.directModelSubstitute(Locale.class, String.class);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
