package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class Description {

	private String cargoDescId;

	private String sequence;

	private String cargoDesc;

	private String cargoDescText;

	private String createdDate;

	private String tpdLevelInd;

	private String updatedDate;

	public String getCargoDescId() {
		return cargoDescId;
	}

	public void setCargoDescId(String cargoDescId) {
		this.cargoDescId = cargoDescId;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getCargoDesc() {
		return cargoDesc;
	}

	public void setCargoDesc(String cargoDesc) {
		this.cargoDesc = cargoDesc;
	}

	public String getCargoDescText() {
		return cargoDescText;
	}

	public void setCargoDescText(String cargoDescText) {
		this.cargoDescText = cargoDescText;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getTpdLevelInd() {
		return tpdLevelInd;
	}

	public void setTpdLevelInd(String tpdLevelInd) {
		this.tpdLevelInd = tpdLevelInd;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Description [cargoDescId=" + cargoDescId + ", sequence=" + sequence + ", cargoDesc=" + cargoDesc
				+ ", cargoDescText=" + cargoDescText + ", createdDate=" + createdDate + ", tpdLevelInd=" + tpdLevelInd
				+ ", updatedDate=" + updatedDate + "]";
	}

	
}
