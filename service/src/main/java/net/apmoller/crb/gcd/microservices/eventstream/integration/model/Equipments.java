package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class Equipments {
	
	private String totalVolume;

    private String customerWeightLbs;

    private String referenceString;

    private String customerWeightKgs;

    private String isShortShipped;

    private String updatedDate;

    private String countSizeRKEM;

    private String equipmentGrossWeightLbs;

    private String totalWeightKgs;

    private String instanceId;

    private String createdDate;

    private String isoCode;

    private List<Seals> seals;

    private String equipmentGrossWeightKgs;

    private String equipmentNoWhenBooked;

    private String countTypeRKEM;

    private boolean shipperOwned;

    private String optionalEquipmentNo;

    private String packageCount;

    private String tareWeight;

	public String getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getCustomerWeightLbs() {
		return customerWeightLbs;
	}

	public void setCustomerWeightLbs(String customerWeightLbs) {
		this.customerWeightLbs = customerWeightLbs;
	}

	public String getReferenceString() {
		return referenceString;
	}

	public void setReferenceString(String referenceString) {
		this.referenceString = referenceString;
	}

	public String getCustomerWeightKgs() {
		return customerWeightKgs;
	}

	public void setCustomerWeightKgs(String customerWeightKgs) {
		this.customerWeightKgs = customerWeightKgs;
	}

	public String getIsShortShipped() {
		return isShortShipped;
	}

	public void setIsShortShipped(String isShortShipped) {
		this.isShortShipped = isShortShipped;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCountSizeRKEM() {
		return countSizeRKEM;
	}

	public void setCountSizeRKEM(String countSizeRKEM) {
		this.countSizeRKEM = countSizeRKEM;
	}

	public String getEquipmentGrossWeightLbs() {
		return equipmentGrossWeightLbs;
	}

	public void setEquipmentGrossWeightLbs(String equipmentGrossWeightLbs) {
		this.equipmentGrossWeightLbs = equipmentGrossWeightLbs;
	}

	public String getTotalWeightKgs() {
		return totalWeightKgs;
	}

	public void setTotalWeightKgs(String totalWeightKgs) {
		this.totalWeightKgs = totalWeightKgs;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public List<Seals> getSeals() {
		return seals;
	}

	public void setSeals(List<Seals> seals) {
		this.seals = seals;
	}

	public String getEquipmentGrossWeightKgs() {
		return equipmentGrossWeightKgs;
	}

	public void setEquipmentGrossWeightKgs(String equipmentGrossWeightKgs) {
		this.equipmentGrossWeightKgs = equipmentGrossWeightKgs;
	}

	public String getEquipmentNoWhenBooked() {
		return equipmentNoWhenBooked;
	}

	public void setEquipmentNoWhenBooked(String equipmentNoWhenBooked) {
		this.equipmentNoWhenBooked = equipmentNoWhenBooked;
	}

	public String getCountTypeRKEM() {
		return countTypeRKEM;
	}

	public void setCountTypeRKEM(String countTypeRKEM) {
		this.countTypeRKEM = countTypeRKEM;
	}

	public boolean isShipperOwned() {
		return shipperOwned;
	}

	public void setShipperOwned(boolean shipperOwned) {
		this.shipperOwned = shipperOwned;
	}

	public String getOptionalEquipmentNo() {
		return optionalEquipmentNo;
	}

	public void setOptionalEquipmentNo(String optionalEquipmentNo) {
		this.optionalEquipmentNo = optionalEquipmentNo;
	}

	public String getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(String packageCount) {
		this.packageCount = packageCount;
	}

	public String getTareWeight() {
		return tareWeight;
	}

	public void setTareWeight(String tareWeight) {
		this.tareWeight = tareWeight;
	}

	@Override
	public String toString() {
		return "Equipments [totalVolume=" + totalVolume + ", customerWeightLbs=" + customerWeightLbs
				+ ", referenceString=" + referenceString + ", customerWeightKgs=" + customerWeightKgs
				+ ", isShortShipped=" + isShortShipped + ", updatedDate=" + updatedDate + ", countSizeRKEM="
				+ countSizeRKEM + ", equipmentGrossWeightLbs=" + equipmentGrossWeightLbs + ", totalWeightKgs="
				+ totalWeightKgs + ", instanceId=" + instanceId + ", createdDate=" + createdDate + ", isoCode="
				+ isoCode + ", seals=" + seals + ", equipmentGrossWeightKgs=" + equipmentGrossWeightKgs
				+ ", equipmentNoWhenBooked=" + equipmentNoWhenBooked + ", countTypeRKEM=" + countTypeRKEM
				+ ", shipperOwned=" + shipperOwned + ", optionalEquipmentNo=" + optionalEquipmentNo + ", packageCount="
				+ packageCount + ", tareWeight=" + tareWeight + "]";
	}

   
}
