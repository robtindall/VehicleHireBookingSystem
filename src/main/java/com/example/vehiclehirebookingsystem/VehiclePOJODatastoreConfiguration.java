package com.example.vehiclehirebookingsystem;

import com.example.vehiclehirebookingsystem.model.Vehicle;
import com.example.vehiclehirebookingsystem.repository.VehicleRepository;
import com.example.vehiclehirebookingsystem.repository.pojodatastore.VehiclePOJODatastore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.vehiclehirebookingsystem.model.FuelType.DIESEL;
import static com.example.vehiclehirebookingsystem.model.FuelType.PETROL;
import static com.example.vehiclehirebookingsystem.model.VehicleCategory.*;

@Configuration
public class VehiclePOJODatastoreConfiguration {

    @Bean
    VehicleRepository vehicleRepository() {
        List<Vehicle> vehicles = createVehicles();
        return new VehiclePOJODatastore(vehicles);
    }

    private List<Vehicle> createVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(Vehicle.builder()
                .id(1000L)
                .registrationNumber("CC034T")
                .category(VAN)
                .make("Ford")
                .model("Transit")
                .fuel(DIESEL)
                .build());
        vehicles.add(Vehicle.builder()
                .id(1001L)
                .registrationNumber("CC034S")
                .category(SMALL_CAR)
                .make("Ford")
                .model("Kia")
                .fuel(PETROL)
                .build());
        vehicles.add(Vehicle.builder()
                .id(1002L)
                .registrationNumber("HIT55500")
                .category(ESTATE_CAR)
                .make("Nissan")
                .model("Bluebird")
                .fuel(PETROL)
                .build());
        vehicles.add(Vehicle.builder()
                .id(1003L)
                .registrationNumber("DWT600S")
                .category(SMALL_CAR)
                .make("Mini")
                .model("Cooper")
                .fuel(PETROL)
                .build());
        vehicles.add(Vehicle.builder()
                .id(1004L)
                .registrationNumber("KES123FG")
                .category(ESTATE_CAR)
                .make("Toyota")
                .model("Corola")
                .fuel(PETROL)
                .hireEndDate(LocalDate.of(2021, 4,1))
                .hiredByCustomer("Nessa Jenkins")
                .build());
        vehicles.add(Vehicle.builder()
                .id(1005L)
                .registrationNumber("GTH670X")
                .category(VAN)
                .make("Toyota")
                .model("Hiace")
                .fuel(DIESEL)
                .hireEndDate(LocalDate.of(2021, 1,11))
                .hiredByCustomer("Dave's Coaches")
                .build());
        return vehicles;
    }

}
