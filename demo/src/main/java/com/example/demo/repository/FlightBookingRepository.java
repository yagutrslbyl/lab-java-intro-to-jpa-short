package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

    List<FlightBooking> findByCustomer(Customer customer);
}
