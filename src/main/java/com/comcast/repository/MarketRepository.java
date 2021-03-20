package com.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comcast.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Integer> {

}
