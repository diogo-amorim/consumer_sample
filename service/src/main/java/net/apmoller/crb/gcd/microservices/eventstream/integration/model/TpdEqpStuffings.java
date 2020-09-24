package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class TpdEqpStuffings {

	private String isOOG;

	private String volumeCbm;

	private String weightLbs;

	private String createdDate;

	private String stuffingId;

	private String weightKgs;

	private String updatedDate;

	private String tpdEquipments;

	private String numberOfPackages;

	private String measureCbm;

	public String getIsOOG() {
		return isOOG;
	}

	public void setIsOOG(String isOOG) {
		this.isOOG = isOOG;
	}

	public String getVolumeCbm() {
		return volumeCbm;
	}

	public void setVolumeCbm(String volumeCbm) {
		this.volumeCbm = volumeCbm;
	}

	public String getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(String weightLbs) {
		this.weightLbs = weightLbs;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStuffingId() {
		return stuffingId;
	}

	public void setStuffingId(String stuffingId) {
		this.stuffingId = stuffingId;
	}

	public String getWeightKgs() {
		return weightKgs;
	}

	public void setWeightKgs(String weightKgs) {
		this.weightKgs = weightKgs;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getTpdEquipments() {
		return tpdEquipments;
	}

	public void setTpdEquipments(String tpdEquipments) {
		this.tpdEquipments = tpdEquipments;
	}

	public String getNumberOfPackages() {
		return numberOfPackages;
	}

	public void setNumberOfPackages(String numberOfPackages) {
		this.numberOfPackages = numberOfPackages;
	}

	public String getMeasureCbm() {
		return measureCbm;
	}

	public void setMeasureCbm(String measureCbm) {
		this.measureCbm = measureCbm;
	}

	@Override
	public String toString() {
		return "TpdEqpStuffings [isOOG=" + isOOG + ", volumeCbm=" + volumeCbm + ", weightLbs=" + weightLbs
				+ ", createdDate=" + createdDate + ", stuffingId=" + stuffingId + ", weightKgs=" + weightKgs
				+ ", updatedDate=" + updatedDate + ", tpdEquipments=" + tpdEquipments + ", numberOfPackages="
				+ numberOfPackages + ", measureCbm=" + measureCbm + "]";
	}
	
	

}
