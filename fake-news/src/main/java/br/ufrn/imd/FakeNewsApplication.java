package br.ufrn.imd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.ufrn.imd.entity")
@EnableJpaRepositories("br.ufrn.imd.repository")
public class FakeNewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeNewsApplication.class, args);
    }
}
