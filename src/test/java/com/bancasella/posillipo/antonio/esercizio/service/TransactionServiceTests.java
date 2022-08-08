package com.bancasella.posillipo.antonio.esercizio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountTransactionsResponse;

@SpringBootTest
public class TransactionServiceTests {

	@Autowired
	private TransactionService transactionService;
	
	private String accountIdOk = "14537780";

	@Test
	void testAddTransactions() {
		List<GetCashAccountTransactionsResponse> transactionsResponse = new ArrayList<GetCashAccountTransactionsResponse>();
		GetCashAccountTransactionsResponse t1 = new GetCashAccountTransactionsResponse();
		t1.setTransactionId("1");
		transactionsResponse.add(t1);
		GetCashAccountTransactionsResponse t2 = new GetCashAccountTransactionsResponse();
		t2.setTransactionId("1");
		transactionsResponse.add(t2);
		boolean result = transactionService.addTransactions(transactionsResponse, accountIdOk);
		assertEquals(true, result);
	}
}
