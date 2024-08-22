package com.example.twrental.service;

import com.example.twrental.entity.Booking;
import com.example.twrental.entity.Car;
import com.example.twrental.entity.Customer;
import com.example.twrental.repository.BookingRepository;
import com.example.twrental.repository.CarRepository;
import com.example.twrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;

    // Hämta alla bokningar
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Hämta en bokning baserat på ID
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Skapa en ny bokning
    public Booking createBooking(Long customerId, Long carId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + carId));

        if (car.getIsBooked()) {
            throw new IllegalStateException("Car is already booked.");
        }

        car.setIsBooked(true);
        carRepository.save(car);

        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setCustomer(customer);
        booking.setCar(car);

        return bookingRepository.save(booking);
    }

    // Avboka (ta bort) en bokning
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + bookingId));

        Car car = booking.getCar();
        car.setIsBooked(false);
        carRepository.save(car);

        bookingRepository.delete(booking);
    }
}
