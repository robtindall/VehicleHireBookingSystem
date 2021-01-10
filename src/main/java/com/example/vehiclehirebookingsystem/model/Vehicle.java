package com.example.vehiclehirebookingsystem.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * Models a hire vehicle. It holds details of the customer that is currently hiring the vehicle and when that hire
 * period ends. The hiredByCustomer and hireEndDate are null when the vehicle is available for hire.
 */
@JsonNaming(SnakeCaseStrategy.class)
@Builder
@Value
public class Vehicle {
    long id;
    String registrationNumber;
    VehicleCategory category;
    String make;
    String model;
    FuelType fuel;
    LocalDate hireEndDate;
    String hiredByCustomer;
}
