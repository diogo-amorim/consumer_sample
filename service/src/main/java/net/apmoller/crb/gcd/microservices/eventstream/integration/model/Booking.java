package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class Booking {
	
	private String isHouse;

	private String transportDocVersion;

	private String tpdHermisVersion;

	private List<Shipment> shipments;

	private String updateStrucTime;

	private String operatorCode;

	private String cargoDestination;

	private String isIVCReceived;

	private String tpDocumentNo;

	private String instanceId;

	private String uAdmOperatorOwner;

	private String isOperationShipment;

	private String scacCode;

	private String isCustomReferencePresent;

	private String isHitchment;

	private String complianceRequired;

	private String loadPortRoutePointSequence;

	private String isTransportDocLevelPrinting;

	private String iSCargoDestPresent;

	public String getIsHouse() {
		return isHouse;
	}

	public void setIsHouse(String isHouse) {
		this.isHouse = isHouse;
	}

	public String getTransportDocVersion() {
		return transportDocVersion;
	}

	public void setTransportDocVersion(String transportDocVersion) {
		this.transportDocVersion = transportDocVersion;
	}

	public String getTpdHermisVersion() {
		return tpdHermisVersion;
	}

	public void setTpdHermisVersion(String tpdHermisVersion) {
		this.tpdHermisVersion = tpdHermisVersion;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public String getUpdateStrucTime() {
		return updateStrucTime;
	}

	public void setUpdateStrucTime(String updateStrucTime) {
		this.updateStrucTime = updateStrucTime;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getCargoDestination() {
		return cargoDestination;
	}

	public void setCargoDestination(String cargoDestination) {
		this.cargoDestination = cargoDestination;
	}

	public String getIsIVCReceived() {
		return isIVCReceived;
	}

	public void setIsIVCReceived(String isIVCReceived) {
		this.isIVCReceived = isIVCReceived;
	}

	public String getTpDocumentNo() {
		return tpDocumentNo;
	}

	public void setTpDocumentNo(String tpDocumentNo) {
		this.tpDocumentNo = tpDocumentNo;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getuAdmOperatorOwner() {
		return uAdmOperatorOwner;
	}

	public void setuAdmOperatorOwner(String uAdmOperatorOwner) {
		this.uAdmOperatorOwner = uAdmOperatorOwner;
	}

	public String getIsOperationShipment() {
		return isOperationShipment;
	}

	public void setIsOperationShipment(String isOperationShipment) {
		this.isOperationShipment = isOperationShipment;
	}

	public String getScacCode() {
		return scacCode;
	}

	public void setScacCode(String scacCode) {
		this.scacCode = scacCode;
	}

	public String getIsCustomReferencePresent() {
		return isCustomReferencePresent;
	}

	public void setIsCustomReferencePresent(String isCustomReferencePresent) {
		this.isCustomReferencePresent = isCustomReferencePresent;
	}

	public String getIsHitchment() {
		return isHitchment;
	}

	public void setIsHitchment(String isHitchment) {
		this.isHitchment = isHitchment;
	}

	public String getComplianceRequired() {
		return complianceRequired;
	}

	public void setComplianceRequired(String complianceRequired) {
		this.complianceRequired = complianceRequired;
	}

	public String getLoadPortRoutePointSequence() {
		return loadPortRoutePointSequence;
	}

	public void setLoadPortRoutePointSequence(String loadPortRoutePointSequence) {
		this.loadPortRoutePointSequence = loadPortRoutePointSequence;
	}

	public String getIsTransportDocLevelPrinting() {
		return isTransportDocLevelPrinting;
	}

	public void setIsTransportDocLevelPrinting(String isTransportDocLevelPrinting) {
		this.isTransportDocLevelPrinting = isTransportDocLevelPrinting;
	}

	public String getiSCargoDestPresent() {
		return iSCargoDestPresent;
	}

	public void setiSCargoDestPresent(String iSCargoDestPresent) {
		this.iSCargoDestPresent = iSCargoDestPresent;
	}

	@Override
	public String toString() {
		return "Booking [isHouse=" + isHouse + ", transportDocVersion=" + transportDocVersion + ", tpdHermisVersion="
				+ tpdHermisVersion + ", shipments=" + shipments + ", updateStrucTime=" + updateStrucTime
				+ ", operatorCode=" + operatorCode + ", cargoDestination=" + cargoDestination + ", isIVCReceived="
				+ isIVCReceived + ", tpDocumentNo=" + tpDocumentNo + ", instanceId=" + instanceId
				+ ", uAdmOperatorOwner=" + uAdmOperatorOwner + ", isOperationShipment=" + isOperationShipment
				+ ", scacCode=" + scacCode + ", isCustomReferencePresent=" + isCustomReferencePresent + ", isHitchment="
				+ isHitchment + ", complianceRequired=" + complianceRequired + ", loadPortRoutePointSequence="
				+ loadPortRoutePointSequence + ", isTransportDocLevelPrinting=" + isTransportDocLevelPrinting
				+ ", iSCargoDestPresent=" + iSCargoDestPresent + "]";
	}


}
