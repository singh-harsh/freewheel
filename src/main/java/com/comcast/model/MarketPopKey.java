package com.comcast.model;

import java.io.Serializable;
import java.util.Objects;

public class MarketPopKey implements Serializable {

	private static final long serialVersionUID = 1L;

	public MarketPopKey() {
	}

	public MarketPopKey(int marketId, int cellId) {
		this.marketId = marketId;
		this.cellId = cellId;
	}

	private int marketId;

	private int cellId;

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MarketPopKey marketPopKey = (MarketPopKey) o;
		return marketId == marketPopKey.marketId && cellId == marketPopKey.cellId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marketId, cellId);
	}

}
