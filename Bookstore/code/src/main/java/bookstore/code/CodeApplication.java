package bookstore.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
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

       
        repository.findAll().forEach(book -> System.out.println(book.toString()));
    };
}


}