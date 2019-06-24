package com.yuanzhi.pojo;

public class FusionCharts {

	private String label ;
	private String value ;
	public String getLabel() {
		return label;
	}
	public FusionCharts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FusionCharts(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "FusionCharts [label=" + label + ", value=" + value + "]";
	}
	
	
}
