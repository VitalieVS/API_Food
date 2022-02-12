package com.vsdev.electronics;


import com.vsdev.electronics.util.sql.SQLAccessor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;
import javax.sql.DataSource;


@SpringBootApplication
public class ElectronicsApplication implements CommandLineRunner {

    private final DataSource dataSource;

    @Inject
    public ElectronicsApplication(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    public static void main(String[] args) {

        SQLAccessor.createSchema();
        SpringApplication.run(ElectronicsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }

}
