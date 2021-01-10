package com.example.vehiclehirebookingsystem;

import com.example.vehiclehirebookingsystem.model.Vehicle;
import com.example.vehiclehirebookingsystem.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

import static java.time.temporal.ChronoUnit.DAYS;

@RequiredArgsConstructor
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Collection<Vehicle> getVehicles(boolean showAvailableOnly) {
        return showAvailableOnly
                ? vehicleRepository.getVehiclesCurrentlyAvailableForHire()
                : vehicleRepository.getAllVehicles();
    }

    public long calculateCostOfHire(long id, LocalDate from, LocalDate to) {
        Vehicle vehicle = vehicleRepository.getVehicle(id);
        int poundsPerDay = vehicle.getCategory().getCostOfHire();
        long differenceInDays = DAYS.between(from, to);
        return differenceInDays * poundsPerDay;
    }

}
