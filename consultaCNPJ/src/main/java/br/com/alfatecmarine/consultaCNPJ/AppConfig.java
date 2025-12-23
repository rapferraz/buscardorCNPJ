package br.com.alfatecmarine.consultaCNPJ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfig {
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OpenAPI customOpenAPI() { 
        return new OpenAPI() 
            .info(new Info() 
                .title("Consulta CNPJ API") 
                .version("1.0") 
                .description("API para consulta de CNPJs usando BrasilAPI")); 
    }
}
