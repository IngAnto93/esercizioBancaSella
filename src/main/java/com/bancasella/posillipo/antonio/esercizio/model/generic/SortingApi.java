package com.bancasella.posillipo.antonio.esercizio.model.generic;

public class SortingApi {

	private String fieldName;

	private String type;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SortingApi [fieldName=" + fieldName + ", type=" + type + "]";
	}

}
