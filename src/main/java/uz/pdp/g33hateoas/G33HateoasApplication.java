package uz.pdp.g33hateoas;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import uz.pdp.g33hateoas.domain.Comment;
import uz.pdp.g33hateoas.repo.CommentRepository;

@SpringBootApplication
public class G33HateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(G33HateoasApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(CommentRepository commentRepository) {
//        return args -> {
//            RestTemplate restTemplate = new RestTemplate();
//            Comment[] comments = restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class);
//            assert comments != null;
//            commentRepository.saveAll(Arrays.asList(comments));
//
//        };
//    }
}
