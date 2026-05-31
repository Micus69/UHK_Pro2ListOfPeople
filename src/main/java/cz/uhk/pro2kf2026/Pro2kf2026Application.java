package cz.uhk.pro2kf2026;

import cz.uhk.pro2kf2026.model.User;
import cz.uhk.pro2kf2026.repository.UserRepository;
import cz.uhk.pro2kf2026.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Pro2kf2026Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro2kf2026Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner testUserCreator(UserRepository userRepository, UserService userService) {
        return args -> {
            userRepository.deleteAll();
            System.out.println(">>>>> The users table has been completely cleared! <<<<<");

            User admin = new User();
            admin.setUsername("admin");
            admin.setName("Admin");
            admin.setPassword("admin123");
            admin.setRole("ADMIN");

            userService.saveUser(admin);
            System.out.println(">>>>> Default admin (admin / admin123) has been successfully saved to the database! <<<<<");
        };
    }
}