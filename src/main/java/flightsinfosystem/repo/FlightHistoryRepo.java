package flightsinfosystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flightsinfosystem.entities.FlightHistory;
import flightsinfosystem.entities.FlightKey;

public interface FlightHistoryRepo extends JpaRepository<FlightHistory, FlightKey> {

	//8
	@Query(value = "SELECT fh.* from flights f join flight_history fh on f.flightno=fh.flightno where DATEDIFF(MINUTE,f.arrivaltime,fh.arrivaltime)>=:min",nativeQuery = true)
	List<FlightHistory> getDelayedFlights(@Param("min") int min);

	//11
	@Query("from FlightHistory where remarks_fh='Rescheduled'")
	List<FlightHistory> rescheduledFlights();
}