package com.subscription.service;

public class SubscriptionService {
	private int durationMonths;
	private String subscriptionType;

	public SubscriptionService(int durationMonths, String subscriptionType) {
		this.durationMonths = durationMonths;
		this.subscriptionType = subscriptionType;
	}

	public double calculateFee() {
		double monthlyRate;
		switch (subscriptionType.toLowerCase()) {
		case "basic":
			monthlyRate = 5.99;
			break;
		case "premium":
			monthlyRate = 9.99;
			break;
		default:
			return 0.0;
		}

		double discount = 1.0;
		if (durationMonths >= 12) {
			discount = 0.9;
		}

		return durationMonths * monthlyRate * discount;
	}
}
