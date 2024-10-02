package bookstore.code.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookAppUserRepository extends CrudRepository<BookAppUser, Long> {
    Optional<BookAppUser> findByUsername(String username); 
}