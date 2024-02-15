package com.subscription.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.subscription.service.SubscriptionService;

public class SubscriptionTest {
	SubscriptionService service = null;

	@Test
	public void testCalculateFee_BasicMonthly() {
		service = new SubscriptionService(1, "basic");
		assertEquals(5.99, service.calculateFee(), 0.001);
	}

	@Test
	public void testCalculateFee_PremiumMonthly() {
		service = new SubscriptionService(1, "premium");
		assertEquals(9.99, service.calculateFee(), 0.001);
	}

	@Test
	public void testCalculateFee_BasicAnnual() {
		service = new SubscriptionService(12, "basic");
		assertEquals(64.69, service.calculateFee(), 0.001); // 12 * 5.99 * 0.9
	}

	@Test
	public void testCalculateFee_PremiumAnnual() {
		service = new SubscriptionService(12, "premium");
		assertEquals(107.89, service.calculateFee(), 0.001); // 12 * 9.99 * 0.9
	}

	@Test
	public void testCalculateFee_InvalidType() {
		service = new SubscriptionService(1, "gold");
		assertEquals(0.0, service.calculateFee(), 0.001); // Invalid subscription type
	}

	@Test
	public void testCalculateFee_BasicSixMonths() {
		service = new SubscriptionService(6, "basic");
		assertEquals(35.94, service.calculateFee(), 0.001); // 6 * 5.99
	}

	@Test
	public void testCalculateFee_PremiumSixMonths() {
		service = new SubscriptionService(6, "premium");
		assertEquals(59.94, service.calculateFee(), 0.001); // 6 * 9.99
	}
}
