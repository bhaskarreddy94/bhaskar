package com.ats.ATOS;

import lombok.Data;

//@Data
/**
 * @author SUNDAR
 *
 */
public class PageModel {
	private int page;
	private int size;
	private String properties;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	

}


