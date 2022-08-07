package com.bancasella.posillipo.antonio.esercizio.model.generic;

public class PaginationApi {

	private int pageCount;

	private int resultCount;

	private int offset;

	private int limit;

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "PaginationApi [pageCount=" + pageCount + ", resultCount=" + resultCount + ", offset=" + offset
				+ ", limit=" + limit + "]";
	}

}
