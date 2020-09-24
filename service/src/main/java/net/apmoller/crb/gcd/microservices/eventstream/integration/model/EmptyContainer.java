package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class EmptyContainer {

	private String tpDocumentNo;
	
	private List<Equipments> equipments;

	private List<Routes> routes;

	private String isEmpty;

	private String operatorCode;

	public String getTpDocumentNo() {
		return tpDocumentNo;
	}

	public void setTpDocumentNo(String tpDocumentNo) {
		this.tpDocumentNo = tpDocumentNo;
	}

	public List<Equipments> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipments> equipments) {
		this.equipments = equipments;
	}

	public List<Routes> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Routes> routes) {
		this.routes = routes;
	}

	public String getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(String isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	@Override
	public String toString() {
		return "EmptyContainer [tpDocumentNo=" + tpDocumentNo + ", equipments=" + equipments + ", routes=" + routes
				+ ", isEmpty=" + isEmpty + ", operatorCode=" + operatorCode + "]";
	}

	
}
