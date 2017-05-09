package com.qicaisheng.cdc.consumer2;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class Consumer2PactTests {

	@Rule
	public PactProviderRule mockProvider = new PactProviderRule("provider", "localhost", 8080, this);

	@Pact(state = "consumer2 get students", provider="provider", consumer="consumer2")
	public PactFragment createFragment(PactDslWithProvider builder) throws JsonProcessingException {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json;charset=utf-8");

		return builder
				.given("contract for consumer2")
				.uponReceiving("Get students")
				.path("/students")
				.method("GET")
				.willRespondWith()
				.status(200)
				.headers(headers)
				.body("[{\"id\": 5, \"age\": 18}]")
				.toFragment();
	}

	@Test
	@PactVerification("provider")
	public void runTest() {
		List<Student> students = new Consumer2Application().getStudents();

		assertEquals(1, students.size());
		assertEquals(5, students.get(0).getId());
		assertEquals(18, students.get(0).getAge());
	}
}
