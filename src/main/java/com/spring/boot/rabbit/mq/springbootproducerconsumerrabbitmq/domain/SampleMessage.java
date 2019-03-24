package com.spring.boot.rabbit.mq.springbootproducerconsumerrabbitmq.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="SampleMessage")
public class SampleMessage {
	private String field1;
	private long field2;
	private List<String> listOfStrings = new ArrayList<String>();
	private Map<String,String> sampleMap = new HashMap<>();
	
	public SampleMessage(String field1, long field2, List<String> listOfStrings) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.listOfStrings = listOfStrings;
	}
	
	public SampleMessage() {
		super();
	}

	@Override
	public String toString() {
		return "SampleMessage [field1=" + field1 + ", field2=" + field2 + ", listOfStrings=" + listOfStrings
				+ ", sampleMap=" + sampleMap + "]";
	}

	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public long getField2() {
		return field2;
	}
	public void setField2(long field2) {
		this.field2 = field2;
	}
	public List<String> getListOfStrings() {
		return listOfStrings;
	}
	public void setListOfStrings(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
	public Map<String, String> getSampleMap() {
		return sampleMap;
	}
	public void setSampleMap(Map<String, String> sampleMap) {
		this.sampleMap = sampleMap;
	}
	
	

}
