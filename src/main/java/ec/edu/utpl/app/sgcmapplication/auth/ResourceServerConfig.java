package ec.edu.utpl.app.sgcmapplication.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/gst_examenes/**").permitAll()
				.antMatchers(HttpMethod.GET, "/gst_especialidad/listar_especialidades").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/gst_medico/listar_medico").hasRole("MEDICO").anyRequest().authenticated()
				.and().cors().configurationSource(corsConfigurationSource());
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://loaclhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;

	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {

		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
