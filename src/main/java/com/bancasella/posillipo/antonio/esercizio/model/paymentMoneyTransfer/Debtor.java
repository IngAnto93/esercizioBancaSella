package com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer;

public class Debtor {

	private String name;

	private Account account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Debtor [name=" + name + ", account=" + account.toString() + "]";
	}

}
