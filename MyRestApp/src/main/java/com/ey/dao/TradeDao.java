package com.ey.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ey.entity.Trade;

public class TradeDao {

	private static List<Trade> trades = new ArrayList<>();
	
	static {
		Trade trade = new Trade();
		trade.setTradeId(12345);
		trade.setRegion("NY");
		trade.setAmount(999);
		trade.setDate(LocalDate.now());
		trades.add(trade);
	}
	
	public void add(Trade trade) {
		trades.add(trade);
	}

	public Trade fetch(int id) {
		return trades
				.stream()
				.filter(trade -> trade.getTradeId() == id)
				.findAny()
				.get();
	}

}
