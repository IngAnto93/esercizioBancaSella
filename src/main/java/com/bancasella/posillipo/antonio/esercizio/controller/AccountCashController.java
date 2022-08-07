package com.bancasella.posillipo.antonio.esercizio.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountBalanceResponse;
import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountTransactionsResponse;
import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseList;
import com.bancasella.posillipo.antonio.esercizio.model.generic.GenericApiResponseObject;
import com.bancasella.posillipo.antonio.esercizio.service.TransactionService;
import com.esercizio.posillipo.antonio.esercizio.utils.HttpClient;

@RestController
public class AccountCashController {

	static Logger logger = LoggerFactory.getLogger(AccountCashController.class);

	@Value("${baseUrl}")
	private String baseUrl;

	@Value("${apiKey}")
	private String apiKey;

	private HttpClient client = new HttpClient();
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping(path = "/letturaSaldo/{accountId}", produces = "application/json")
	public ResponseEntity<GenericApiResponseObject<GetCashAccountBalanceResponse>> getLetturaSaldo(
			@PathVariable(value = "accountId") String accountId) {
		logger.info("Start call to LetturaSaldo service. Parameters: accountId=" + accountId);
		Map<String, String> headers = new HashMap<>();
		headers.put("Api-Key", apiKey);
		String url = baseUrl + "/api/gbs/banking/v4.0/accounts/" + accountId + "/balance";
		@SuppressWarnings("unchecked")
		GenericApiResponseObject<GetCashAccountBalanceResponse> response = client.doRequest("GET", url, headers, null,
				GenericApiResponseObject.class);
		logger.info("End call to LetturaSaldo service");
		if (response.getStatus().equalsIgnoreCase("OK")) {
			return new ResponseEntity<GenericApiResponseObject<GetCashAccountBalanceResponse>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<GenericApiResponseObject<GetCashAccountBalanceResponse>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/letturaTransazioni/{accountId}", produces = "application/json")
	public ResponseEntity<GenericApiResponseList<GetCashAccountTransactionsResponse>> getLetturaTransazioni(
			@PathVariable(value = "accountId") String accountId, @RequestParam("dallaData") String fromAccountingDate,
			@RequestParam("allaData") String toAccountingDate) {
		logger.info("Start call to LetturaTransazioni service. Parameters: accountId=" + accountId
				+ ", fromAccountingDate=" + fromAccountingDate + ", toAccountingDate=" + toAccountingDate);
		Map<String, String> headers = new HashMap<>();
		headers.put("Api-Key", apiKey);
		String url = baseUrl + "/api/gbs/banking/v4.0/accounts/" + accountId + "/transactions?fromAccountingDate="
				+ fromAccountingDate + "&toAccountingDate=" + toAccountingDate;
		@SuppressWarnings("unchecked")
		GenericApiResponseList<GetCashAccountTransactionsResponse> response = client.doRequest("GET", url, headers,
				null, GenericApiResponseList.class);
		logger.info("End call to LetturaTransazioni service");
		if (response.getStatus().equalsIgnoreCase("OK")) {
			boolean addTransactions = transactionService.addTransactions(response.getPayload().getList(), accountId);
			if (addTransactions) {
				return new ResponseEntity<GenericApiResponseList<GetCashAccountTransactionsResponse>>(response,
						HttpStatus.OK);	
			} else {
				logger.info("Error during transaction store");
				return new ResponseEntity<GenericApiResponseList<GetCashAccountTransactionsResponse>>(response,
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<GenericApiResponseList<GetCashAccountTransactionsResponse>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
