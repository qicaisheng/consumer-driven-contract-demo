package com.qicaisheng.cdc.provider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.restdriver.clientdriver.ClientDriverRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.List;

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;

@RunWith(PactRunner.class)
@Provider("provider")
@PactFolder("pacts")
public class ProviderPactTests {
	@ClassRule
	public static final ClientDriverRule embeddedService = new ClientDriverRule(8080);

	@TestTarget // Annotation denotes Target that will be used for tests
	public final Target target = new HttpTarget(8080);

	@Before
	public void before() throws JsonProcessingException {
		ProviderApplication providerApplication = new ProviderApplication();
		List<Student> students = providerApplication.getStudents();
		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writeValueAsString(students);

		embeddedService.addExpectation(
				onRequestTo("/students"), giveResponse(body, "application/json;charset=utf-8"));
	}
}
