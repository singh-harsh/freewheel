package com.comcast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comcast.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
	public List<Program> findByStationIdOrderByFlightDateAsc(int stationId);
}