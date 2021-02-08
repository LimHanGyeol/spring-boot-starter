package com.tommy.bootstart.bootuptake.database.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Section3. Spring Boot 활용
 * Spring Data JPA
 */
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void di() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            assertThat(metaData.getDriverName()).isEqualTo("H2 JDBC Driver");
            assertThat(metaData.getUserName()).isEqualToIgnoringCase("SA");
        }
    }

    @Test
    void account_create() {
        Account account = new Account("hangyeol", "pass");

        Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount).isNotNull();

        Account existingAccount = accountRepository.findByUsername(savedAccount.getUsername())
                                                   .orElseThrow(RuntimeException::new);

        assertThat(existingAccount.getId()).isEqualTo(1L);
    }
}
