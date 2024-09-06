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
        repository.save(new Book("1984", "George Orwell", 1949, "978-0415249353", 19.99));
        repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "978-0415903626", 14.99));
    };
}
}
