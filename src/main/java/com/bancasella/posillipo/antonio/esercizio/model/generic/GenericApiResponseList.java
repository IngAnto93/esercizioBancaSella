package com.bancasella.posillipo.antonio.esercizio.model.generic;

import java.util.List;

import com.esercizio.posillipo.antonio.esercizio.utils.ListToString;

public class GenericApiResponseList<T> {

	private String status;

	private List<ErrorApi> errors;

	private PayloadApi<T> payload;

	private ListToString<ErrorApi> listToString;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorApi> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorApi> errors) {
		this.errors = errors;
	}

	public PayloadApi<T> getPayload() {
		return payload;
	}

	public void setPayload(PayloadApi<T> payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "GenericApiResponseList [status=" + status + ", errors=" + listToString.convertListToString(errors)
				+ ", payload=" + payload.toString() + "]";
	}

}
