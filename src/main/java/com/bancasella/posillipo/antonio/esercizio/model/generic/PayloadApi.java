package com.bancasella.posillipo.antonio.esercizio.model.generic;

import java.util.List;

import com.esercizio.posillipo.antonio.esercizio.utils.ListToString;

public class PayloadApi<T> {

	private List<T> list;

	private PaginationApi pagination;

	private SegmentationApi segmentation;

	private SortingApi sorting;

	private ListToString<T> listToString;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PaginationApi getPagination() {
		return pagination;
	}

	public void setPagination(PaginationApi pagination) {
		this.pagination = pagination;
	}

	public SegmentationApi getSegmentation() {
		return segmentation;
	}

	public void setSegmentation(SegmentationApi segmentation) {
		this.segmentation = segmentation;
	}

	public SortingApi getSorting() {
		return sorting;
	}

	public void setSorting(SortingApi sorting) {
		this.sorting = sorting;
	}

	@Override
	public String toString() {
		return "PayloadApi [list=" + listToString.convertListToString(list) + ", pagination=" + pagination.toString()
				+ ", segmentation=" + segmentation.toString() + ", sorting=" + sorting.toString() + "]";
	}

}
