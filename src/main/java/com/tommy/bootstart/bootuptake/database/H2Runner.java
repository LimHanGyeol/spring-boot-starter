package com.tommy.bootstart.bootuptake.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Section3. Spring Boot 활용
 * In-memory Database
 */
@Component
public class H2Runner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(H2Runner.class);

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    public H2Runner(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            String url = connection.getMetaData().getURL();
            String userName = connection.getMetaData().getUserName();

            log.info(String.format("datasource url : %s", url));
            log.info(String.format("datasource username : %s", userName));

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INT(9) NOT NULL AUTO_INCREMENT, NAME VARCHAR(10) NOT NULL, PRIMARY KEY(ID))";
            statement.executeUpdate(sql);
        }

        jdbcTemplate.execute("INSERT INTO USER (NAME) VALUES ('HANGYEOL')");
    }
}
