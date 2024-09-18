package com.ey.entity;

import java.time.LocalDate;

public class Trade {

	private int tradeId;
	private String region;
	private double amount;
	private LocalDate date;
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", region=" + region + ", amount=" + amount + ", date=" + date + "]";
	}
}
