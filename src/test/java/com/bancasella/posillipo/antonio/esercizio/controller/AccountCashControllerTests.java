package com.bancasella.posillipo.antonio.esercizio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountBalanceResponse;
import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountTransactionsResponse;
import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseList;
import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseObject;
import com.esercizio.posillipo.antonio.esercizio.utils.HttpClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AccountCashControllerTests {

	@LocalServerPort
	private int port;

	private HttpClient client = new HttpClient();
	private String accountIdOk = "14537780";
	private String accountIdKo = "14537781";
	private Map<String, String> headers = new HashMap<>();

	@Test
	void testLetturaSaldo() {
		String baseUrl = "http://localhost:" + port + "/letturaSaldo/";
		String urlOk = baseUrl + accountIdOk;
		String urlKo = baseUrl + accountIdKo;

		GenericApiResponseObject<GetCashAccountBalanceResponse> responseOk = client.doRequest("GET",
				urlOk, headers, null, GenericApiResponseObject.class);
		assertEquals("OK", responseOk.getStatus());
		
		GenericApiResponseObject<GetCashAccountBalanceResponse> responseKo = client.doRequest("GET", urlKo, headers,
				null, GenericApiResponseObject.class);
		assertEquals("KO", responseKo.getStatus());
	}
	
	@Test
	void testLetturaTransazioni() {
		String baseUrl = "http://localhost:" + port + "/letturaTransazioni/";
		String urlOk = baseUrl + accountIdOk + "?dallaData=2019-04-01&allaData=2019-04-01";
		String urlKo = baseUrl + accountIdKo + "?dallaData=2019-04-01&allaData=2019-04-01";
		
		GenericApiResponseList<GetCashAccountTransactionsResponse> responseOk = client.doRequest("GET",
				urlOk, headers, null, GenericApiResponseList.class);
		assertEquals("OK", responseOk.getStatus());
		
		GenericApiResponseList<GetCashAccountTransactionsResponse> responseKo = client.doRequest("GET",
				urlKo, headers, null, GenericApiResponseList.class);
		assertEquals("KO", responseKo.getStatus());
	}
}
