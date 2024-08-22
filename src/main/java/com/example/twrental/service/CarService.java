package com.example.twrental.service;

import com.example.twrental.entity.Car;
import com.example.twrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Hämta alla bilar
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    // Hämta alla tillgängliga bilar (inte bokade)
    public List<Car> findAvailableCars() {
        return carRepository.findAll().stream()
                .filter(car -> !car.getIsBooked())
                .toList();
    }

    // Hämta bil via ID
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    // Spara eller uppdatera en bil
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    // Ta bort bil via ID
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    // Hämta alla bilar
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Hämta en bil baserat på ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }
}