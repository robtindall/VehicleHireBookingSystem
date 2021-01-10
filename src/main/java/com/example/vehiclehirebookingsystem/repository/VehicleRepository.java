package com.example.vehiclehirebookingsystem.repository;

import com.example.vehiclehirebookingsystem.model.Vehicle;

import java.util.Collection;

public interface VehicleRepository {

    Collection<Vehicle> getAllVehicles();

    Vehicle getVehicle(long id) throws VehicleNotFoundException;

    Collection<Vehicle> getVehiclesCurrentlyAvailableForHire();
}
