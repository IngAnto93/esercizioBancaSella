package com.bancasella.posillipo.antonio.esercizio.model;

public class GetCashAccountTransactionsResponse {

	private String transactionId;

	private String operationId;

	private String accountingDate;

	private String valueDate;

	private String type;

	private Double amount;

	private String currency;

	private String description;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GetCashAccountTransactionsResponse [transactionId=" + transactionId + ", operationId=" + operationId
				+ ", accountingDate=" + accountingDate + ", valueDate=" + valueDate + ", type=" + type + ", amount="
				+ amount + ", currency=" + currency + ", description=" + description + "]";
	}

}
