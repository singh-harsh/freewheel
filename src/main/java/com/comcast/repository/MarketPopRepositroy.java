package com.comcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comcast.model.MarketPop;
import com.comcast.model.MarketPopKey;

@Repository
public interface MarketPopRepositroy extends JpaRepository<MarketPop, MarketPopKey> {

}
