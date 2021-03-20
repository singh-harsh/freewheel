package com.comcast.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.model.Cells;
import com.comcast.model.Market;
import com.comcast.model.MarketPop;
import com.comcast.model.Program;
import com.comcast.model.Station;
import com.comcast.service.FreewheelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/freewheel")
public class FreewheelController {

	@Autowired
	private FreewheelService freewheelService;

	ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(method = RequestMethod.GET, value = "/programs")
	public List<String> ProcessProgramName() {
		List<Program> allProgromsAsc = freewheelService.getAllPrograms();
		return allProgromsAsc.stream().map(e -> "'" + e.getProgramName().replaceAll("'", "''") + "'")
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/stations")
	public String getStations() throws JsonProcessingException {
		List<Station> stations = freewheelService.getAllStations();
		return mapper.writeValueAsString(stations);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/programbystationid/{stationId}")
	public String getProgramByStationId(@PathVariable String stationId) {
		try {
			List<Program> programList = freewheelService.getAllProgramsByStationId(Integer.parseInt(stationId));
			if (programList.isEmpty()) {
				return "No records found!";
			}
			return new SimpleDateFormat("MMM dd, YYYY").format(programList.get(0).getFlightDate());
		} catch (NumberFormatException e) {
			return "Invalid station id";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cartesian")
	public String getCartesian() {
		List<Market> marketList = freewheelService.getAllMarket();
		List<Cells> cellList = freewheelService.getAllCell();
		List<MarketPop> allMarketPops = freewheelService.cartesian(marketList, cellList);
		List<MarketPop> availableMarketPops = freewheelService.getAllMarketPop();
		List<MarketPop> missingMarketPops = allMarketPops.stream().filter(e -> !availableMarketPops.contains(e))
				.collect(Collectors.toList());
		freewheelService.saveMarketPop(missingMarketPops);
		if (missingMarketPops.isEmpty()) {
			return "No missing markets pops";
		}
		return missingMarketPops.size() + " missing rows added!";
	}

}
