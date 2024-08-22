package com.example.twrental.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate bookingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private com.example.twrental.entity.Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private com.example.twrental.entity.Car car;

    public Booking() {}

    // Konstruktör med alla fält
    public Booking(LocalDate bookingDate, com.example.twrental.entity.Customer customer, com.example.twrental.entity.Car car) {
        this.bookingDate = bookingDate;
        this.customer = customer;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public com.example.twrental.entity.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.example.twrental.entity.Customer customer) {
        this.customer = customer;
    }

    public com.example.twrental.entity.Car getCar() {
        return car;
    }

    public void setCar(com.example.twrental.entity.Car car) {
        this.car = car;
    }
}
