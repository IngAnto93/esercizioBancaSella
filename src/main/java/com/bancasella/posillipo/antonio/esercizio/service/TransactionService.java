package com.bancasella.posillipo.antonio.esercizio.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancasella.posillipo.antonio.esercizio.entity.Transaction;
import com.bancasella.posillipo.antonio.esercizio.model.GetCashAccountTransactionsResponse;
import com.bancasella.posillipo.antonio.esercizio.repository.TransactionRepository;

@Service
public class TransactionService {

	static Logger logger = LoggerFactory.getLogger(TransactionService.class);

	@Autowired
	private TransactionRepository transactionRepository;

	public boolean addTransactions(List<GetCashAccountTransactionsResponse> transactionsResponse, String accountId) {
		boolean retVal = true;
		for (int i = 0; i < transactionsResponse.size(); i++) {
			if (transactionsResponse.get(i).getTransactionId() != null
					&& transactionRepository.findById(transactionsResponse.get(i).getTransactionId()).isEmpty()) {
				Transaction t = new Transaction();
				t.setTransactionId(transactionsResponse.get(i).getTransactionId());
				t.setOperationId(transactionsResponse.get(i).getOperationId());
				t.setAccountingDate(transactionsResponse.get(i).getAccountingDate());
				t.setValueDate(transactionsResponse.get(i).getValueDate());
				t.setAmount(transactionsResponse.get(i).getAmount());
				t.setCurrency(transactionsResponse.get(i).getCurrency());
				t.setDescription(transactionsResponse.get(i).getDescription());
				t.setType(transactionsResponse.get(i).getType());
				t.setAccountId(accountId);
				try {
					transactionRepository.save(t);
				} catch (Exception e) {
					logger.error(e.getMessage());
					retVal = false;
					break;
				}
			}
		}
		return retVal;
	}
}
