package messagingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"messagingapp.model"})
public class MessagingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingAppApplication.class, args);
    }
}
