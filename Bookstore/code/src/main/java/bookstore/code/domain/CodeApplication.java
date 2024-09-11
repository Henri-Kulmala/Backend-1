package bookstore.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
@EntityScan("bookstore.code")
@EnableJpaRepositories("bookstore.code")
public class CodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
    return (args) -> {
        
        Book s1 = new Book("Kasvoton Kuolema", "Hennig Mankell", null, null, 12.0);
        Book s2 = new Book("Riian Verikoirat", "Hennig Mankell", null, null, 13.0);
       
        
     
        repository.save(s1);
        repository.save(s2);

       
        
    };
}


}