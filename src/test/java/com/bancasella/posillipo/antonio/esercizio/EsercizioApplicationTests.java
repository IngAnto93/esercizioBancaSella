package com.bancasella.posillipo.antonio.esercizio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Account;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Address;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Amount;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Creditor;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Debtor;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.Fee;
import com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer.PaymentMoneyTransferResponse;

@SpringBootTest
class EsercizioApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testModels() {
		PaymentMoneyTransferResponse p = new PaymentMoneyTransferResponse();
		p.setMoneyTransferId(null);
		p.getMoneyTransferId();
		p.setStatus(null);
		p.getStatus();
		p.setDirection(null);
		p.getDirection();
		Creditor c = new Creditor();
		c.setAccount(new Account());
		c.setAddress(new Address());
		p.setCreditor(c);
		p.getCreditor();
		Debtor d = new Debtor();
		d.setAccount(new Account());
		p.setDebtor(d);
		p.getDebtor();
		p.setCro(null);
		p.getCro();
		p.setUri(null);
		p.getUri();
		p.setTrn(null);
		p.getTrn();
		p.setDescription(null);
		p.getDescription();
		p.setCreatedDatetime(null);
		p.getCreatedDatetime();
		p.setAccountedDatetime(null);
		p.getAccountedDatetime();
		p.setDebtorValueDate(null);
		p.getDebtorValueDate();
		p.setCreditorValueDate(null);
		p.getCreditorValueDate();
		p.setAmount(new Amount());
		p.getAmount();
		p.setIsUrgent(false);
		p.getIsUrgent();
		p.setIsInstant(true);
		p.getIsInstant();
		p.setFeeType(null);
		p.getFeeType();
		p.setFeeAccountId(null);
		p.getFeeAccountId();
		p.setHasTaxRelief(null);
		p.getHasTaxRelief();
		List<Fee> fees = new ArrayList<Fee>();
		Fee fee = new Fee();
		fees.add(fee);
		p.setFees(fees);
		p.getFees();
	}

}
