package Actividad4.Configuration.Domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "database")
@RequiredArgsConstructor
@Data
public class DatabaseCredentials {
	private String host;
    private String port;
    private String username;
    private String password;
    private String database;
}
