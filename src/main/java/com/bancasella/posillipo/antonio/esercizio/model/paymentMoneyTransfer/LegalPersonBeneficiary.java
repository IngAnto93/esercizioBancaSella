package com.bancasella.posillipo.antonio.esercizio.model.paymentMoneyTransfer;

public class LegalPersonBeneficiary {

	private String fiscalCode;
	
	private String legalRepresentativeFiscalCode;

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}

	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}

	@Override
	public String toString() {
		return "LegalPersonBeneficiary [fiscalCode=" + fiscalCode + ", legalRepresentativeFiscalCode="
				+ legalRepresentativeFiscalCode + "]";
	}
	
}
