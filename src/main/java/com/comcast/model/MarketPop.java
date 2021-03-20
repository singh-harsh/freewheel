package com.comcast.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "market_pop")
@IdClass(MarketPopKey.class)
public class MarketPop implements Serializable {

	private static final long serialVersionUID = 1L;

	public MarketPop() {

	}

	public MarketPop(int marketId, int cellId) {
		this.marketId = marketId;
		this.cellId = cellId;
	}

	@Id
	@Column(name = "MARKET_ID")
	private int marketId;

	@Id
	@Column(name = "CELL_ID")
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
		MarketPop marketPop = (MarketPop) o;
		return marketId == marketPop.marketId && cellId == marketPop.cellId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(marketId, cellId);
	}

}
