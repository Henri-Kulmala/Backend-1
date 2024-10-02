package bookstore.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import bookstore.code.domain.Book;
import bookstore.code.domain.BookAppUser;
import bookstore.code.domain.BookAppUserRepository;
import bookstore.code.domain.BookRepository;

import java.util.Set; 

@SpringBootApplication
@EntityScan("bookstore.code")
@EnableJpaRepositories("bookstore.code")
public class CodeApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Bean
    public CommandLineRunner initDatabase(BookAppUserRepository userRepository) { 
        return args -> {
            userRepository.save(new BookAppUser("admin", passwordEncoder.encode("password"), "admin@bookstore.com", Set.of("ADMIN")));
            userRepository.save(new BookAppUser("user", passwordEncoder.encode("password"), "user@bookstore.com", Set.of("USER")));
        };
    }
}
