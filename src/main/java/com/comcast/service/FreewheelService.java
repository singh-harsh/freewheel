package com.comcast.service;

import static java.util.Collections.emptyList;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comcast.model.Cells;
import com.comcast.model.Market;
import com.comcast.model.MarketPop;
import com.comcast.model.Program;
import com.comcast.model.Station;
import com.comcast.repository.CellRepository;
import com.comcast.repository.MarketPopRepositroy;
import com.comcast.repository.MarketRepository;
import com.comcast.repository.ProgramRepository;
import com.comcast.repository.StationRepository;

@Service
public class FreewheelService {

	@Autowired
	private ProgramRepository programRepository;

	@Autowired
	private StationRepository stationRepository;

	@Autowired
	private MarketRepository marketRepository;

	@Autowired
	private CellRepository cellRepository;

	@Autowired
	private MarketPopRepositroy marketPopRepositroy;

	public List<Program> getAllPrograms() {
		return programRepository.findAll(Sort.by(Sort.Direction.ASC, "programName"));
	}

	public List<Station> getAllStations() {
		return stationRepository.findAll();
	}

	public List<Program> getAllProgramsByStationId(int stationId) {
		return programRepository.findByStationIdOrderByFlightDateAsc(stationId);
	}

	public List<Market> getAllMarket() {
		return marketRepository.findAll();
	}

	public List<Cells> getAllCell() {
		return cellRepository.findAll();
	}

	public List<MarketPop> getAllMarketPop() {
		return marketPopRepositroy.findAll();
	}

	public void saveMarketPop(List<MarketPop> marketPopKey) {
		marketPopRepositroy.saveAll(marketPopKey);
	}

	public List<MarketPop> cartesian(List<Market> a, List<Cells> b) {
		return of(a.stream().map(e1 -> of(b.stream().map(e2 -> {
			return new MarketPop(e1.getMarketId(), e2.getCellId());
		}).collect(toList())).orElse(emptyList())).flatMap(List::stream).collect(toList())).orElse(emptyList());
	}

}
