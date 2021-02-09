package com.tommy.bootstart.bootuptake.security.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Section3. Spring Boot 활용
 * Spring Security
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsername(String username);

}
