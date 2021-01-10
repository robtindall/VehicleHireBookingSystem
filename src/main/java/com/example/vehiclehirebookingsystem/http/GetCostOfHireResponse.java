package com.example.vehiclehirebookingsystem.http;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * The response object for the request to get cost of hire.
 */
@RequiredArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
@Value
public class GetCostOfHireResponse {
    long cost;
}