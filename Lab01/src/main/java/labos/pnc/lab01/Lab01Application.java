package labos.pnc.lab01;

import labos.pnc.lab01.service.Services;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab01Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab01Application.class, args);
    }

    @Bean
    public CommandLineRunner run(Services productService) {
        return args -> {
            System.out.println("=== INICIANDO APP ===");
            productService.findAll().forEach(p ->
                    System.out.println(p.getName() + " - $" + p.getPrice())
            );
        };
    }

}
