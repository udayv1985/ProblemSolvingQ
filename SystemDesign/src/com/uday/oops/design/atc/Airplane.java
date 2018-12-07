package com.uday.oops.design.atc;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
	
	private Long airplaneId;
	
	private String name; 
	
	private AirplaneAction request; 
	
	private AirplaneAction currentStatus; 
	
	private List<AirTrafficController> atcList;
	
	private String source;
	
	private String destination;
	
	public void setRequest(AirplaneAction request) {
		this.request= request;
	}
	
	public void processRequest(AirplaneAction request) {
		for(AirTrafficController atc : atcList){
			atc.call(this);
		}
	}
	
	public void registerAtc(AirTrafficController atc){
		if(null == atcList){
			atcList = new ArrayList<AirTrafficController>();
		}
		this.atcList.add(atc);
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AirplaneAction getRequest() {
		return request;
	}

	public List<AirTrafficController> getAtcList() {
		return atcList;
	}

	public void setAtcList(List<AirTrafficController> atcList) {
		this.atcList = atcList;
	}

	public AirplaneAction getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(AirplaneAction currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	} 
	
	

}
