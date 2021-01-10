package com.example.vehiclehirebookingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A enumeration of the vehicle categories.
 */
@AllArgsConstructor
@Getter
public enum VehicleCategory {
    SMALL_CAR(25), ESTATE_CAR(35), VAN(50);

    /**
     * The cost in pounds to hire the vehicle for a day.
     */
    private int costOfHire;
}
