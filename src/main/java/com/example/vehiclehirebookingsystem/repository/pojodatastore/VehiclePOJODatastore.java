package com.example.vehiclehirebookingsystem.repository.pojodatastore;

import com.example.vehiclehirebookingsystem.model.Vehicle;
import com.example.vehiclehirebookingsystem.repository.VehicleNotFoundException;
import com.example.vehiclehirebookingsystem.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * A vehicle repository that holds all vehicle as a list of POJOs. This is not suitable for production, it will be
 * replaced by a persistent datastore in future interations.
 *
 * TODO replace with a persistent datastore.
 */
@RequiredArgsConstructor
public class VehiclePOJODatastore implements VehicleRepository {
    private final List<Vehicle> vehicles;

    @Override
    public Collection<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public Vehicle getVehicle(long id) throws VehicleNotFoundException {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findAny()
                .orElseThrow(() -> new VehicleNotFoundException("Failed to find vehicle with identifier: " + id));
    }

    @Override
    public Collection<Vehicle> getVehiclesCurrentlyAvailableForHire() {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getHireEndDate() == null)
                .collect(toList());
    }
}
