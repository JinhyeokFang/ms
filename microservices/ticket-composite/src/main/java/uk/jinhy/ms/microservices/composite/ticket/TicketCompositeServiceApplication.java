package uk.jinhy.ms.microservices.composite.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("uk.jinhy.ms")
@EnableFeignClients
public class TicketCompositeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketCompositeServiceApplication.class, args);
    }
}
