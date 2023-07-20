package flightsinfosystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scheduled_flights")
public class ScheduledFlight {

	@Column(name = "departuretime")
	private String deptime_sf;

	@Column(name = "arrivaldate")
	private String arrdate_sf;

	@Column(name = "arrivaltime")
	private String arrtime_sf;

	@Column(name = " duration_in_minutes")
	private int mins_sf;
	@EmbeddedId
	private FlightKey keysf;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "flightno", insertable = false, updatable = false)
	private Flight flightno_sf;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "fromcity", referencedColumnName = "code")
	private City fromcity_sf;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tocity",referencedColumnName = "code")
	private City tocity_sf;

	public String getDeptime_sf() {
		return deptime_sf;
	}

	public void setDeptime_sf(String deptime_sf) {
		this.deptime_sf = deptime_sf;
	}

	public String getArrdate_sf() {
		return arrdate_sf;
	}

	public void setArrdate_sf(String arrdate_sf) {
		this.arrdate_sf = arrdate_sf;
	}

	public String getArrtime_sf() {
		return arrtime_sf;
	}

	public void setArrtime_sf(String arrtime_sf) {
		this.arrtime_sf = arrtime_sf;
	}

	public int getMins_sf() {
		return mins_sf;
	}

	public void setMins_sf(int mins_sf) {
		this.mins_sf = mins_sf;
	}

	public FlightKey getKeysf() {
		return keysf;
	}

	public void setKeysf(FlightKey keysf) {
		this.keysf = keysf;
	}

	public Flight getFlightno_sf() {
		return flightno_sf;
	}

	public void setFlightno_sf(Flight flightno_sf) {
		this.flightno_sf = flightno_sf;
	}

	public City getFromcity_sf() {
		return fromcity_sf;
	}

	public void setFromcity_sf(City fromcity_sf) {
		this.fromcity_sf = fromcity_sf;
	}

	public City getTocity_sf() {
		return tocity_sf;
	}

	public void setTocity_sf(City tocity_sf) {
		this.tocity_sf = tocity_sf;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [deptime_sf=" + deptime_sf + ", arrdate_sf=" + arrdate_sf + ", arrtime_sf=" + arrtime_sf
				+ ", mins_sf=" + mins_sf + ", keysf=" + keysf + ", flightno_sf=" + flightno_sf + ", fromcity_sf="
				+ fromcity_sf + ", tocity_sf=" + tocity_sf + "]";
	}

	
	}

