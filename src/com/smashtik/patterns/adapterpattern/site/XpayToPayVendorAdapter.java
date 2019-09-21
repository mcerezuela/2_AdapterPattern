package com.smashtik.patterns.adapterpattern.site;

import com.smashtik.patterns.adapterpattern.payd.PayVendor;
import com.smashtik.patterns.adapterpattern.xpay.Xpay;

public class XpayToPayVendorAdapter implements PayVendor {

	private String custCardNo;
	private String cardOwnerName;
	private String cardExpMonthDate;
	private Integer cVVNo;
	private Double totalAmount;
	private Integer fidelity;
	
	private final Xpay xpay;
	
	public XpayToPayVendorAdapter(Xpay xpay){
		this.xpay = xpay;
		setProp();
	}

	@Override
	public String getCustCardNo() {
		return custCardNo;
	}

	@Override
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	@Override
	public String getCardExpMonthDate() {
		return cardExpMonthDate;
	}

	@Override
	public Integer getCVVNo() {
		return cVVNo;
	}

	@Override
	public Double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public Integer getFidelityPoints() { return this.fidelity; }

	@Override
	public void setCustCardNo(String custCardNo) {
		this.custCardNo = custCardNo;
	}

	@Override
	public void setCardOwnerName(String cardOwnerName) { this.cardOwnerName = cardOwnerName; }

	@Override
	public void setCardExpMonthDate(String cardExpMonthDate) {
		this.cardExpMonthDate = cardExpMonthDate;
	}

	@Override
	public void setCVVNo(Integer cVVNo) {
		this.cVVNo = cVVNo;
	}

	@Override
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public void setFidelityPoints(Integer points) { this.fidelity = points;}

	@Override
	public void addFidelityPoints(Integer points) { this.setFidelityPoints(this.getFidelityPoints()+points);}


	private void setProp(){
		setCardOwnerName(this.xpay.getCustomerName());
		setCustCardNo(this.xpay.getCreditCardNo());
		setCardExpMonthDate(this.xpay.getCardExpMonth()+"/"+this.xpay.getCardExpYear());
		setCVVNo(this.xpay.getCardCVVNo().intValue());
		setTotalAmount(this.xpay.getAmount());
		setFidelityPoints(Integer.valueOf(this.xpay.getFidelityPoints()));
	}

}
