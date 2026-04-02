package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Flight;
import com.example.demo.entity.FlightBooking;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.FlightBookingRepository;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private FlightRepository flightRepo;

    @Autowired
    private FlightBookingRepository bookingRepo;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Customer c1 = new Customer("Ali", CustomerStatus.GOLD, 5000);
        Customer c2 = new Customer("Ayşe", CustomerStatus.SILVER, 3000);

        customerRepo.saveAll(List.of(c1, c2));

        Flight f1 = new Flight("TK101", "Boeing 737", 180, 1200);
        Flight f2 = new Flight("TH202", "Airbus A320", 150, 900);

        flightRepo.saveAll(List.of(f1, f2));

        FlightBooking b1 = new FlightBooking(c1, f1);
        FlightBooking b2 = new FlightBooking(c2, f2);


        bookingRepo.saveAll(List.of(b1, b2));

        System.out.println("Sample data inserted!");
    }


}
