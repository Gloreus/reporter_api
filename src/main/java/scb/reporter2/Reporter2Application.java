package scb.reporter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("scb.reporter2.repositories")
public class Reporter2Application {

    public static void main(String[] args) {
        SpringApplication.run(Reporter2Application.class, args);
    }

}
