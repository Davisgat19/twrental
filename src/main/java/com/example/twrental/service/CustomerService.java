package com.example.twrental.service;

import com.example.twrental.entity.Customer;
import com.example.twrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Hämta alla kunder
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Hämta en kund baserat på ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Spara en ny kund eller uppdatera en befintlig
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Uppdatera en befintlig kund
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setUsername(updatedCustomer.getUsername());
                    customer.setName(updatedCustomer.getName());
                    customer.setAddress(updatedCustomer.getAddress());
                    customer.setEmail(updatedCustomer.getEmail());
                    customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));
    }

    // Ta bort en kund baserat på ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
