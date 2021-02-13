package com.tr.hr.dto;

import java.util.List;

/**
 * 
 * @author ozaytunctan
 *
 * @param <T>
 */
public class PagedResultDto<T> {

	public static final long DEFAULT_OFFSET = 0;

	public static final int DEFAULT_MAX_NO_OF_ROWS = 100;

	/**
	 * page number index
	 */
	private int offset;
	/**
	 * page size
	 */
	private int limit;
	/**
	 * Total element
	 */
	private long totalElements;
	/**
	 * 
	 */
	private List<T> elements;

	public PagedResultDto(List<T> elements, long totalElements, int offset, int limit) {
		this.elements = elements;
		this.totalElements = totalElements;
		this.offset = offset;
		this.limit = limit;
	}

	public boolean hasMore() {
		return totalElements > offset + limit;
	}

	public boolean hasPrevious() {
		return offset > 0 && totalElements > 0;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}

	public List<T> getElements() {
		return elements;
	}
}