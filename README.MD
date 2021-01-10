#How to run the application

1. Run in a command line `./mvnw spring-boot:run`
2. Open http://localhost:8080 in your browser

#Other documentation
* The assumptions I made at start of exercise [Assumptions](docs/Assumptions.md)
* The REST API Design [REST API Design](docs/RestApiDesign.md)
* User interface mockups [UI Design](docs/UI-Design.md)

#To the reviewer

The backend part of this exercise was well within my comfort zone. I have spent the past
three years working in a team of backend developers. So writing a REST API felt familiar.

Building a SPA was outside of my comfort zone. I am familiar with javascript, html and css. 
But I have not been involved in this type of work for a few years. I have had studied some
javascript frameworks in my own time and focussed on React. For this exercise I decided to 
challenge myself to develop the app in Vue, a framework I had not seen before. My hope was to
prove my exposure to other frameworks would enable me pick this up easily. I am pleased that
I was able to deliver a working solution, but I would not consider it to be much more than a 
prototype. Please bear this in mind when reviewing it.

#Thing that should be done
* The SPA needs more work as it does not use the full power of Vue yet.
* There needs to be some test coverage for the SPA, I would suggest a set of tests that run the SPA with a mocked out Rest API.
* Switch to a persistent datastore by implementing [VehicleRepository](src/main/java/com/example/vehiclehirebookingsystem/repository/VehicleRepository.java)
* The [VehicleHireBookingSystemApplicationTests](src/test/java/com/example/vehiclehirebookingsystem/VehicleHireBookingSystemApplicationTests.java) needs completing as it is not currently making any assertions on the data returned.
_These were not done because I could not fit them into the 1-2 hours recommended._

#Things that could be done
* Improve styling of SPA