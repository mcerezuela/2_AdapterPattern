package com.smashtik.patterns.adapterpattern.site;

import com.smashtik.patterns.adapterpattern.payd.PayVendor;
import com.smashtik.patterns.adapterpattern.xpay.Xpay;

public class RunAdapterExample {

	public static void main(String[] args) {
		
		// Object for Xpay
		Xpay xpay = new XpayImpl();
		xpay.setCreditCardNo("4789565874102365");
		xpay.setCustomerName("Max Warner");
		xpay.setCardExpMonth("09");
		xpay.setCardExpYear("25");
		xpay.setCardCVVNo((short)235);
		xpay.setAmount(2565.23);
		xpay.addFidelityPoints("300");
		
		PayVendor payVendor = new XpayToPayVendorAdapter(xpay);
		testPayVendor(payVendor);
		payVendor.addFidelityPoints(45);
		testPayVendor(payVendor);
	}
	
	private static void testPayVendor(PayVendor payVendor){
		
		System.out.println("Card Owner: "+payVendor.getCardOwnerName());
		System.out.println("Card Number: "+payVendor.getCustCardNo());
		System.out.println("Card Expiration: "+payVendor.getCardExpMonthDate());
		System.out.println("Card CVV: "+payVendor.getCVVNo());
		System.out.println("Card Amount: "+payVendor.getTotalAmount());
		System.out.println("Card fidelity Points: "+payVendor.getFidelityPoints());
	}

}
