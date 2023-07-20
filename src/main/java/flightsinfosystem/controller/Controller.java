package flightsinfosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import flightsinfosystem.entities.City;
import flightsinfosystem.entities.Flight;
import flightsinfosystem.entities.FlightHistory;
import flightsinfosystem.entities.FlightKey;
import flightsinfosystem.entities.ScheduledFlight;
import flightsinfosystem.repo.CityRepo;
import flightsinfosystem.repo.FlightHistoryRepo;
import flightsinfosystem.repo.FlightRepo;
import flightsinfosystem.repo.ScheduleFlightRepo;

@RestController
@CrossOrigin
public class Controller {

	@Autowired
	private CityRepo cRepo;

	@Autowired
	private FlightRepo fRepo;

	@Autowired
	private ScheduleFlightRepo sfRepo;

	@Autowired
	private FlightHistoryRepo fhRepo;

	@GetMapping("/getcities")
	public List<City> getCity() {
		return cRepo.findAll();
	}

	@GetMapping("/getscheduleflight")
	public List<ScheduledFlight> getsf() {
		return sfRepo.findAll();
	}

	@GetMapping("/getflights")
	public List<Flight> getFlight() {
		return fRepo.findAll();
	}

	@GetMapping("/getflighthistory")
	public List<FlightHistory> getAll() {
		return fhRepo.findAll();
	}
//1

	@GetMapping("/getCityNames")
	public List<String> getcityNames() {
		return cRepo.getCities();
	}

//	@GetMapping("/CityNames")
//	public List<String> getcityByNames() {
//		
//		List<String> cn=new ArrayList<String>();
//		
//		for (var cname:cRepo.findAll()) {
//			cn.add(cname.getName());
//		}
//		
//		return cn;
//	}

//2
	@GetMapping("/getFlightpage/{num}")
	public List<Flight> getFlightPage(@PathVariable("num") int num) {
		var result = fRepo.findAll(PageRequest.of(num, 4));
		return result.getContent();

	}

//3	

	@GetMapping("/getFlightfromcity/{from}/{to}")
	public List<Flight> getFlight(@PathVariable("from") String from, @PathVariable("to") String to) {
		return fRepo.getFlights(from, to);
	}

	@GetMapping("/getFlightfromcities/{from}/{to}")
	public List<String> getFlightBYCity(@PathVariable("from") String from, @PathVariable("to") String to) {
		return fRepo.getFlight(from, to);
	}

//4	
	@GetMapping("/getFlightHistory/{num}")
	public List<FlightHistory> getFlightHistory(@PathVariable("num") String num) {
		return fRepo.findById(num).get().getFlightno_fh();
	}

//5
	@PostMapping("/addScheduledFlight")
	public ScheduledFlight addScheduledFlight(@RequestParam("flightno") String flightno,
			@RequestParam("depdate") String depdate, @RequestParam("arrdate") String arrdate) {
		var flight = fRepo.findById(flightno).get();
		FlightKey cp = new FlightKey();
		cp.setFlightno(flightno);
		cp.setDepdate(depdate);
		ScheduledFlight sf = new ScheduledFlight();
		sf.setArrdate_sf(arrdate);
		sf.setArrtime_sf(flight.getArr_time());
		sf.setDeptime_sf(flight.getDep_time());
		sf.setFromcity_sf(flight.getFromcity_flight());
		sf.setTocity_sf(flight.getTocity_flight());
		sf.setMins_sf(flight.getDur_min());
		sf.setKeysf(cp);
		sfRepo.save(sf);
		return sf;
	}

//6
	@PostMapping("/addFlight")
	public Flight addflight(@RequestParam("fno") String fno, @RequestParam("from") String from,
			@RequestParam("to") String to, @RequestParam("min") int min, @RequestParam("deptime") String deptime,
			@RequestParam("arrivalTime") String arrivalTime, @RequestParam("aircraft") String aircraft) {
		City fc = cRepo.findById(from).get();
		City tc = cRepo.findById(to).get();

		Flight f = new Flight();
		f.setNo(fno);
		f.setFromcity_flight(fc);
		f.setTocity_flight(tc);
		f.setDur_min(min);
		f.setDep_time(deptime);
		f.setArr_time(arrivalTime);
		f.setAircraft(aircraft);

		fRepo.save(f);

		return f;

	}

//7
	@DeleteMapping("/deleteFlight/{ddate}/{sdate}")
	public int deleteFlightByDate(@PathVariable("ddate") String ddate,@PathVariable("sdate") String sdate) {
		return sfRepo.deleteByDate(ddate, sdate);
	}

//08	
	@GetMapping("/delayedFlightHistory")
	public List<FlightHistory> delayedFlights(@RequestParam("min") int min) {
		return fhRepo.getDelayedFlights(min);
	}

//09	
	@PostMapping("/addCities")
	public City addCity(@RequestBody City cities) {
		try {
			cRepo.save(cities);
			return cities;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data!");
		}
	}

	@DeleteMapping("/city/{code}")
	public void deleteCategoryByCode(@PathVariable("code") String code) {
		var city = cRepo.findById(code);
		if (city.isPresent())
			cRepo.deleteById(code);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Code Not Found");
	}

	@PutMapping("/updatecity/{code}/{name}")
	public City updateCities(@PathVariable("code") String code, @PathVariable("name") String name) {
		if (name.length() == 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Description");

		var city = cRepo.findById(code);
		if (city.isPresent()) {
			var c = city.get();
			c.setName("visakha");
			cRepo.save(c);
			return c;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Code Not Found");
	}

//10
	@GetMapping("/getflightScheduled")
	public List<ScheduledFlight> getScheduledFlight(@RequestParam("date") String date, @RequestParam("city") String city) {
		return sfRepo.getScheduleFlight(date, city);
	}


	//11
	@GetMapping("/rescheduled")
    public List<FlightHistory>getRescheduledflights(){
		return fhRepo.rescheduledFlights();
      
	}
	

	

   
	//12
	@GetMapping("/getminutesfromutc/{code}")
	public City getminutes(@PathVariable() String code) {
		City m = cRepo.findById(code).get();
		return m;
	}
	
//13
@GetMapping("/getflight/{fromcity}")
public List<String> getFlight(@PathVariable() String fromcity) {
	List<String> f=fRepo.getflightNo(fromcity);
	return f;
}

/// /14
//@DeleteMapping("/deleteFlight/{ddate}/{sdate}/{flightno}")
//public int deleteFlight(@PathVariable("ddate") String ddate,@PathVariable("sdate") String sdate,@PathVariable("flightno")String flightno) {
//	return sfRepo.delete(ddate, sdate, flightno	);
}



	
