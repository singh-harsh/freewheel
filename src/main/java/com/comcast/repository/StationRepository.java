package com.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comcast.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
	
}