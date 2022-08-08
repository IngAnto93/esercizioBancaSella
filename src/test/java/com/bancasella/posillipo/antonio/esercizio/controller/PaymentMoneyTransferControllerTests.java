package com.bancasella.posillipo.antonio.esercizio.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseObject;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.PaymentMoneyTransferResponse;
import com.esercizio.posillipo.antonio.esercizio.utils.HttpClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PaymentMoneyTransferControllerTests {

	@LocalServerPort
	private int port;

	private HttpClient client = new HttpClient();
	private String accountIdOk = "14537780";
	private String accountIdKo = "14537781";
	private Map<String, String> headers = new HashMap<>();

	@Test
	void testEffettuaBonifico() {
		String baseUrl = "http://localhost:" + port + "/effettuaBonifico/";
		String urlOk = baseUrl + accountIdOk;
		String urlKo = baseUrl + accountIdKo;

		String body = "{\r\n" + "  \"creditor\": {\r\n" + "    \"name\": \"John Doe\",\r\n" + "    \"account\": {\r\n"
				+ "      \"accountCode\": \"IT23A0336844430152923804660\",\r\n"
				+ "      \"bicCode\": \"SELBIT2BXXX\"\r\n" + "    },\r\n" + "    \"address\": {\r\n"
				+ "      \"address\": null,\r\n" + "      \"city\": null,\r\n" + "      \"countryCode\": null\r\n"
				+ "    }\r\n" + "  },\r\n" + "  \"executionDate\": \"2019-04-01\",\r\n"
				+ "  \"uri\": \"REMITTANCE_INFORMATION\",\r\n" + "  \"description\": \"Payment invoice 75/2017\",\r\n"
				+ "  \"amount\": 800,\r\n" + "  \"currency\": \"EUR\",\r\n" + "  \"isUrgent\": false,\r\n"
				+ "  \"isInstant\": false,\r\n" + "  \"feeType\": \"SHA\",\r\n" + "  \"feeAccountId\": null,\r\n"
				+ "  \"taxRelief\": {\r\n" + "    \"taxReliefId\": \"L449\",\r\n" + "    \"isCondoUpgrade\": false,\r\n"
				+ "    \"creditorFiscalCode\": \"56258745832\",\r\n"
				+ "    \"beneficiaryType\": \"NATURAL_PERSON\",\r\n" + "    \"naturalPersonBeneficiary\": {\r\n"
				+ "      \"fiscalCode1\": \"MRLFNC81L04A859L\",\r\n" + "      \"fiscalCode2\": null,\r\n"
				+ "      \"fiscalCode3\": null,\r\n" + "      \"fiscalCode4\": null,\r\n"
				+ "      \"fiscalCode5\": null\r\n" + "    },\r\n" + "    \"legalPersonBeneficiary\": {\r\n"
				+ "      \"fiscalCode\": null,\r\n" + "      \"legalRepresentativeFiscalCode\": null\r\n" + "    }\r\n"
				+ "  }\r\n" + "}";

		GenericApiResponseObject<PaymentMoneyTransferResponse> responseOk = client.doRequest("POST", urlOk, headers,
				body, GenericApiResponseObject.class);
		assertEquals("KO", responseOk.getStatus());

		GenericApiResponseObject<PaymentMoneyTransferResponse> responseKo = client.doRequest("POST", urlKo, headers,
				body, GenericApiResponseObject.class);
		assertEquals("KO", responseKo.getStatus());
	}
}
