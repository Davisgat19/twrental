package com.example.twrental;

import com.example.twrental.entity.Booking;
import com.example.twrental.entity.Car;
import com.example.twrental.entity.Customer;
import com.example.twrental.repository.BookingRepository;
import com.example.twrental.repository.CarRepository;
import com.example.twrental.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(CustomerRepository customerRepository, CarRepository carRepository, BookingRepository bookingRepository) {
        return args -> {
            // Skapa och spara kunder
            Customer customer1 = new Customer("user1", "Alice", "123 Street", "alice@example.com", "1234567890");
            Customer customer2 = new Customer("user2", "Bob", "456 Avenue", "bob@example.com", "0987654321");
            Customer customer3 = new Customer("user3", "Charlie", "789 Boulevard", "charlie@example.com", "5678901234");
            Customer customer4 = new Customer("user4", "David", "1010 Drive", "david@example.com", "4321098765");
            Customer customer5 = new Customer("user5", "Eva", "2020 Road", "eva@example.com", "8765432109");
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

            // Skapa och spara bilar
            Car car1 = new Car("Toyota", "Corolla", "ABC123", 100.0, false);
            Car car2 = new Car("Ford", "Focus", "DEF456", 120.0, false);
            Car car3 = new Car("Honda", "Civic", "GHI789", 90.0, false);
            Car car4 = new Car("Tesla", "Model 3", "JKL012", 150.0, false);
            Car car5 = new Car("BMW", "3 Series", "MNO345", 200.0, false);
            carRepository.save(car1);
            carRepository.save(car2);
            carRepository.save(car3);
            carRepository.save(car4);
            carRepository.save(car5);

            // Skapa och spara bokningar
            Booking booking1 = new Booking(LocalDate.now(), customer1, car1);
            Booking booking2 = new Booking(LocalDate.now().minusDays(1), customer2, car2);
            Booking booking3 = new Booking(LocalDate.now().minusDays(2), customer3, car3);
            bookingRepository.save(booking1);
            bookingRepository.save(booking2);
            bookingRepository.save(booking3);
        };
    }
}
