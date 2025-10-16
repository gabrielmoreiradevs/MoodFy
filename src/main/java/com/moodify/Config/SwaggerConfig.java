package com.moodify.Config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact();
        contact.name("Gabriel Moreira");
        contact.setUrl("https://github.com/gabrielmoreiradevs");

        Info info = new Info();
        info.title("MoodFy");
        info.version("1.0");
        info.description("Aplicação para Gerenciamente de Conteudos/Experiencias Relacionadas ao Humor");
        info.contact(contact);

        return new OpenAPI().info(info);
    }
}
