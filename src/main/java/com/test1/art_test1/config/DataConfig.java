package com.test1.art_test1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Property of CODIX SA
 * Date: 4/19/2020 Time: 1:33 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
@Configuration
public class DataConfig {
  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScripts("db/schema.sql", "db/data.sql")
            .build();
  }

  @Bean(name = {"txManager", "transactionManager"})
  public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean(name = "namedTemplate")
  @Primary
  public NamedParameterJdbcOperations namedTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
    jdbcTemplate.setFetchSize(30);


    jdbcTemplate.setMaxRows(50000);

    NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate);
    npjt.setCacheLimit(384);
    return npjt;
  }
}
