package com.bancasella.posillipo.antonio.esercizio.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseObject;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.PaymentMoneyTransferRequest;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.PaymentMoneyTransferResponse;
import com.esercizio.posillipo.antonio.esercizio.utils.HttpClient;

@RestController
public class PaymentMoneyTransferController {

	static Logger logger = LoggerFactory.getLogger(PaymentMoneyTransferController.class);

	@Value("${baseUrl}")
	private String baseUrl;

	@Value("${apiKey}")
	private String apiKey;

	private HttpClient client = new HttpClient();

	@PostMapping(path = "/effettuaBonifico/{accountId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<GenericApiResponseObject<PaymentMoneyTransferResponse>> effettuaBonifico(
			@PathVariable(value = "accountId") String accountId, @RequestBody PaymentMoneyTransferRequest req) {
		logger.info("Start call to EffettuaBonifico service. Parameters: accountId=" + accountId);
		Map<String, String> headers = new HashMap<>();
		headers.put("Api-Key", apiKey);
		String url = baseUrl + "/api/gbs/banking/v4.0/accounts/" + accountId + "/payments/money-transfers";
		@SuppressWarnings("unchecked")
		GenericApiResponseObject<PaymentMoneyTransferResponse> response = client.doRequest("POST", url, headers, req,
				GenericApiResponseObject.class);
		logger.info("End call to EffettuaBonifico service");
		if (response.getStatus().equalsIgnoreCase("OK")) {
			return new ResponseEntity<GenericApiResponseObject<PaymentMoneyTransferResponse>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<GenericApiResponseObject<PaymentMoneyTransferResponse>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
