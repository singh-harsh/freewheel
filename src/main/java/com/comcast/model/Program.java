package com.comcast.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Program {

	@Column(name = "PROGRAM_ID")
	@Id
	private int programId;

	@Column(name = "STATION_ID")
	private int stationId;

	@Column(name = "PROGRAM_NAME")
	private String programName;

	@Column(name = "FLIGHT_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date flightDate;

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

}
