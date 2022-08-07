package com.bancasella.posillipo.antonio.esercizio.model.generic;

public class SegmentationApi {

	private int segmentLength;
	
	private String segmentId;
	
	private String nextSegmentId;

	public int getSegmentLength() {
		return segmentLength;
	}

	public void setSegmentLength(int segmentLength) {
		this.segmentLength = segmentLength;
	}

	public String getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(String segmentId) {
		this.segmentId = segmentId;
	}

	public String getNextSegmentId() {
		return nextSegmentId;
	}

	public void setNextSegmentId(String nextSegmentId) {
		this.nextSegmentId = nextSegmentId;
	}

	@Override
	public String toString() {
		return "SegmentationApi [segmentLength=" + segmentLength + ", segmentId=" + segmentId + ", nextSegmentId="
				+ nextSegmentId + "]";
	}
	
}
