package com.qicaisheng.cdc.consumer1;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class Consumer1PactTests {

	@Rule
	public PactProviderRule mockProvider = new PactProviderRule("provider", "localhost", 8080, this);

	@Pact(consumer="consumer1")
	public PactFragment createFragment(PactDslWithProvider builder) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json;charset=utf-8");

		return builder
				.given("contract for consumer1")
				.uponReceiving("Get students")
				.path("/students")
				.method("GET")
				.willRespondWith()
				.status(200)
				.headers(headers)
				.body("[{\"id\": 5, \"name\": \"James\"}]")
				.toFragment();
	}

	@Test
	@PactVerification
	public void runTest() {
		List<Student> students = new Consumer1Application().getStudents();

		assertEquals(1, students.size());
		assertEquals(5, students.get(0).getId());
		assertEquals("James", students.get(0).getName());
	}
}
