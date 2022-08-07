package com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer;

import java.util.List;

import com.esercizio.posillipo.antonio.esercizio.utils.ListToString;

public class PaymentMoneyTransferResponse {

	private String moneyTransferId;

	private String status;

	private String direction;

	private Creditor creditor;

	private Debtor debtor;

	private String cro;

	private String uri;

	private String trn;

	private String description;

	private String createdDatetime;

	private String accountedDatetime;

	private String debtorValueDate;

	private String creditorValueDate;

	private Amount amount;

	private Boolean isUrgent;

	private Boolean isInstant;

	private String feeType;

	private String feeAccountId;

	private List<Fee> fees;

	private Boolean hasTaxRelief;

	private ListToString<Fee> listToString;

	public String getMoneyTransferId() {
		return moneyTransferId;
	}

	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Creditor getCreditor() {
		return creditor;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	public Debtor getDebtor() {
		return debtor;
	}

	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getAccountedDatetime() {
		return accountedDatetime;
	}

	public void setAccountedDatetime(String accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}

	public String getDebtorValueDate() {
		return debtorValueDate;
	}

	public void setDebtorValueDate(String debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}

	public String getCreditorValueDate() {
		return creditorValueDate;
	}

	public void setCreditorValueDate(String creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Boolean getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Boolean getIsInstant() {
		return isInstant;
	}

	public void setIsInstant(Boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public Boolean getHasTaxRelief() {
		return hasTaxRelief;
	}

	public void setHasTaxRelief(Boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}

	@Override
	public String toString() {
		return "PaymentMoneyTransferResponse [moneyTransferId=" + moneyTransferId + ", status=" + status
				+ ", direction=" + direction + ", creditor=" + creditor.toString() + ", debtor=" + debtor.toString()
				+ ", cro=" + cro + ", uri=" + uri + ", trn=" + trn + ", description=" + description
				+ ", createdDatetime=" + createdDatetime + ", accountedDatetime=" + accountedDatetime
				+ ", debtorValueDate=" + debtorValueDate + ", creditorValueDate=" + creditorValueDate + ", amount="
				+ amount.toString() + ", isUrgent=" + isUrgent + ", isInstant=" + isInstant + ", feeType=" + feeType
				+ ", feeAccountId=" + feeAccountId + ", fees=" + listToString.convertListToString(fees)
				+ ", hasTaxRelief=" + hasTaxRelief + "]";
	}

}
