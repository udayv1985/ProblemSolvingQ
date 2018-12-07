package com.uday.parking.system;

public class PaymentSrvcFactory {
	
	static PaymentProcessor cash = new CashPayment();
	
	public static PaymentProcessor getPaymentService(String type){
		if(type.equals("CASH")){
			return cash;
		}
		return null;
	}

}
