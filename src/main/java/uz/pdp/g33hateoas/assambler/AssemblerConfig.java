package uz.pdp.g33hateoas.assambler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import uz.pdp.g33hateoas.domain.Comment;

@Configuration
public class AssemblerConfig {

    @Bean
    public PagedResourcesAssembler<Comment> commentPagedResourcesAssembler() {
        return new PagedResourcesAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(), null);
    }
}
