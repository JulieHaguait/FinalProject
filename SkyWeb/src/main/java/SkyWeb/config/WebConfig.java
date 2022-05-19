package SkyWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import SkyMaven.config.SkyConfig;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"SkyMaven.restController"})
@Import(SkyConfig.class)
public class WebConfig {

	

		@Bean
		public UrlBasedViewResolver viewResolver() {
			UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/pages/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}
	}
