package flightsinfosystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flightsinfosystem.entities.FlightKey;
import flightsinfosystem.entities.ScheduledFlight;
import jakarta.transaction.Transactional;

@Transactional
public interface ScheduleFlightRepo extends JpaRepository<ScheduledFlight, FlightKey> {

//10	
	@Query("from ScheduledFlight sf where sf.keysf.depdate =:date and sf.fromcity_sf.code=:city")
	List<ScheduledFlight> getScheduleFlight(@Param("date") String date, @Param("city") String city);

//7
	@Modifying
	@Query(" delete from ScheduledFlight sf where sf.keysf.depdate Between :ddate and :sdate")
	int deleteByDate(@Param("ddate") String ddate, @Param("sdate") String sdate);

	//
//	@Modifying
//	@Query(" delete from ScheduledFlight sf where sf.keysf.depdate Between :ddate and :sdate and flightno=:flightno")
//	int delete(@Param("ddate") String ddate, @Param("sdate") String sdate,@Param("flightno")int flightno);

}

