package flightsinfosystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flightsinfosystem.entities.Flight;

public interface FlightRepo extends JpaRepository<Flight, String> {
//3

	@Query(value = "SELECT  * from flights  where fromcity = :fcode and tocity = :tcode", nativeQuery = true)
	List<Flight> getFlights(@Param("fcode") String fcode, @Param("tcode") String tcode);
//11
	@Query("select f.flightno from Flight f  where f.fromcity_flight.code= :fromcode and f.tocity_flight.code= :tocode")
	List<String> getFlight(@Param("fromcode") String fromcode, @Param("tocode") String tocode);

	//13
	@Query("select flightno from Flight where fromcity_flight.code=:fromcity")
	List<String> getflightNo(@Param("fromcity") String fromcity);
	
}