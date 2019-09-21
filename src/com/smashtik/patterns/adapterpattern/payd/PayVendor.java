package com.smashtik.patterns.adapterpattern.payd;

public interface PayVendor {
	
	public String getCustCardNo();
	public String getCardOwnerName();
	public String getCardExpMonthDate();
	public Integer getCVVNo();
	public Double getTotalAmount();
	public Integer getFidelityPoints();
	
	public void setCustCardNo(String custCardNo);
	public void setCardOwnerName(String cardOwnerName);
	public void setCardExpMonthDate(String cardExpMonthDate);
	public void setCVVNo(Integer cVVNo);
	public void setTotalAmount(Double totalAmount);
	public void setFidelityPoints(Integer points);
	public void addFidelityPoints(Integer points);
}
