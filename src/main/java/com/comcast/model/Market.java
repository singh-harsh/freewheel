package com.comcast.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Market {

	@Id
	@Column(name = "MARKET_ID")
	private int marketId;

	@Column(name = "MARKET_NAME")
	private String marketName;

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

}
