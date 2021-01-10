package com.example.vehiclehirebookingsystem.http;

import com.example.vehiclehirebookingsystem.VehicleService;
import com.example.vehiclehirebookingsystem.model.Vehicle;
import com.example.vehiclehirebookingsystem.repository.VehicleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
public class VehicleController {
    private final VehicleService service;

    @GetMapping(value = "vehicles", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Vehicle> getVehicles(@RequestParam(value = "filter", required = false) String filter) {
        return service.getVehicles("available".equals(filter));
    }

    @GetMapping(value = "vehicles/{id}/cost-of-hire", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GetCostOfHireResponse> getCostOfHire(@PathVariable("id") long id,
                                                              @RequestParam("from_date") @DateTimeFormat(iso = ISO.DATE) LocalDate from,
                                                              @RequestParam("to_date") @DateTimeFormat(iso = ISO.DATE) LocalDate to) {
        if (!from.isBefore(to)) {
            return new ResponseEntity<>(BAD_REQUEST);
        }

        long cost = service.calculateCostOfHire(id, from, to);
        return new ResponseEntity<>(new GetCostOfHireResponse(cost), OK);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public void vehicleNotFoundExceptionHandler(VehicleNotFoundException exception) {
    }
}
