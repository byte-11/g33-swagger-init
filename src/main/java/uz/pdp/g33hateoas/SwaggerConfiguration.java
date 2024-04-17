package uz.pdp.g33hateoas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "G33-HATEOAS APPLICATION",
                description = "This application is for testing cases only",
                version = "${app.version}",
                contact = @Contact(
                        name = "Behzod",
                        url = "https://www.github.com/byte-11",
                        email = "behzod.0001@gmail.com"
                ),
                license = @License(
                        name = "Apache 3.0",
                        url = "https://starter.spring.io"
                ),
                termsOfService = "https://wwww.wiki.com",
                summary = "The project is fully supported by G33 team"
        ),
        servers = {
                @Server(url = "http://localhost:8081/swagger",
                description = "Development Server"),
                @Server(url = "http://localhost:8082/swagger",
                        description = "Production Server"),
                @Server(url = "http://localhost:8080/swagger",
                        description = "Local")
        }
)
public class SwaggerConfiguration {
}
