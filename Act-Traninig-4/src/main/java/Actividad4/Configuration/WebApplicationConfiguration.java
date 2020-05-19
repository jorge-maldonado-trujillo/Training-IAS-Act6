package Actividad4.Configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.gson.Gson;

@Configuration
public class WebApplicationConfiguration implements WebMvcConfigurer{
	private final Gson gson;
	
	public WebApplicationConfiguration(Gson gson) {
		this.gson = gson;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		GsonHttpMessageConverter messageConverter = new GsonHttpMessageConverter(gson);
		converters.add(messageConverter);
	}

}
