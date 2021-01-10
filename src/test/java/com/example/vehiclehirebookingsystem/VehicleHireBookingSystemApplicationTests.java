package com.example.vehiclehirebookingsystem;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class VehicleHireBookingSystemApplicationTests {
	@Autowired
	private MockMvc mvc;

	@SneakyThrows
	@Test
	void shouldReturnAllVehiclesGivenNoFilterParameterIdProvided() {
		mvc.perform(get("/vehicles")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		//TODO assert content
	}

	@SneakyThrows
	@Test
	void shouldReturnAvailableVehiclesGivenFilterAvailableParameterIsProvided() {
		mvc.perform(get("/vehicles?filter=available")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		//TODO assert content
	}

	@SneakyThrows
	@Test
	void shouldReturnCostGivenValidVehicleIdAndDateRange() {
		mvc.perform(get("/vehicles/1000/cost-of-hire?from_date=2021-01-01&to_date=2021-01-22")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		//TODO assert content
	}

	@SneakyThrows
	@Test
	void shouldReturnNotFoundGivenVehicleIdDoesNotExist() {
		mvc.perform(get("/vehicles/1/cost-of-hire?from_date=2021-01-01&to_date=2021-01-22")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@SneakyThrows
	@Test
	void shouldReturnBadRequestGivenInvalidDateRange() {
		mvc.perform(get("/vehicles/1/cost-of-hire?from_date=1-Jan-2021?to_date=5-Jan-2021")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

	@SneakyThrows
	@Test
	void shouldReturnBadRequestGivenToDateIsNotAfterFromDate() {
		mvc.perform(get("/vehicles/1/cost-of-hire?from_date=11-Jan-2021?to_date=10-Jan-2021")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
}
