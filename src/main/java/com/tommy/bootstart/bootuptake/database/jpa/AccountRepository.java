package com.tommy.bootstart.bootuptake.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Section3. Spring Boot 활용
 * Spring Data JPA
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
