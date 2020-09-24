package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class Cargoes {
	
	private String reeferTempratureCelsius;

    private String weightLbs;

    private String freightPaymentMethod;

    private List<TpdFumigationDetails> tpdFumigationDetails;

    private List<Description> description;

    private List<TpdCargoHscodes> tpdCargoHscodes;

    private String updatedDate;

    private List<TpdEqpStuffings> tpdEqpStuffings;

    private String measureCbm;

    private String parentInstanceId;

    private String sequence;

    private String cargoId;

    private String hsCodes;

    private String instanceId;

    private String createdDate;

    private String weightKgs;

    private String weightPricingLbs;

    private List<TpdDngrsDetails> tpdDngrsDetails;

    private String marsCode;

    private String weightPricingKgs;

    private List<TpdCargoPkgs> tpdCargoPkgs;

	public String getReeferTempratureCelsius() {
		return reeferTempratureCelsius;
	}

	public void setReeferTempratureCelsius(String reeferTempratureCelsius) {
		this.reeferTempratureCelsius = reeferTempratureCelsius;
	}

	public String getWeightLbs() {
		return weightLbs;
	}

	public void setWeightLbs(String weightLbs) {
		this.weightLbs = weightLbs;
	}

	public String getFreightPaymentMethod() {
		return freightPaymentMethod;
	}

	public void setFreightPaymentMethod(String freightPaymentMethod) {
		this.freightPaymentMethod = freightPaymentMethod;
	}

	public List<TpdFumigationDetails> getTpdFumigationDetails() {
		return tpdFumigationDetails;
	}

	public void setTpdFumigationDetails(List<TpdFumigationDetails> tpdFumigationDetails) {
		this.tpdFumigationDetails = tpdFumigationDetails;
	}

	public List<Description> getDescription() {
		return description;
	}

	public void setDescription(List<Description> description) {
		this.description = description;
	}

	public List<TpdCargoHscodes> getTpdCargoHscodes() {
		return tpdCargoHscodes;
	}

	public void setTpdCargoHscodes(List<TpdCargoHscodes> tpdCargoHscodes) {
		this.tpdCargoHscodes = tpdCargoHscodes;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<TpdEqpStuffings> getTpdEqpStuffings() {
		return tpdEqpStuffings;
	}

	public void setTpdEqpStuffings(List<TpdEqpStuffings> tpdEqpStuffings) {
		this.tpdEqpStuffings = tpdEqpStuffings;
	}

	public String getMeasureCbm() {
		return measureCbm;
	}

	public void setMeasureCbm(String measureCbm) {
		this.measureCbm = measureCbm;
	}

	public String getParentInstanceId() {
		return parentInstanceId;
	}

	public void setParentInstanceId(String parentInstanceId) {
		this.parentInstanceId = parentInstanceId;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getCargoId() {
		return cargoId;
	}

	public void setCargoId(String cargoId) {
		this.cargoId = cargoId;
	}

	public String getHsCodes() {
		return hsCodes;
	}

	public void setHsCodes(String hsCodes) {
		this.hsCodes = hsCodes;
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

	public String getWeightKgs() {
		return weightKgs;
	}

	public void setWeightKgs(String weightKgs) {
		this.weightKgs = weightKgs;
	}

	public String getWeightPricingLbs() {
		return weightPricingLbs;
	}

	public void setWeightPricingLbs(String weightPricingLbs) {
		this.weightPricingLbs = weightPricingLbs;
	}

	public List<TpdDngrsDetails> getTpdDngrsDetails() {
		return tpdDngrsDetails;
	}

	public void setTpdDngrsDetails(List<TpdDngrsDetails> tpdDngrsDetails) {
		this.tpdDngrsDetails = tpdDngrsDetails;
	}

	public String getMarsCode() {
		return marsCode;
	}

	public void setMarsCode(String marsCode) {
		this.marsCode = marsCode;
	}

	public String getWeightPricingKgs() {
		return weightPricingKgs;
	}

	public void setWeightPricingKgs(String weightPricingKgs) {
		this.weightPricingKgs = weightPricingKgs;
	}

	public List<TpdCargoPkgs> getTpdCargoPkgs() {
		return tpdCargoPkgs;
	}

	public void setTpdCargoPkgs(List<TpdCargoPkgs> tpdCargoPkgs) {
		this.tpdCargoPkgs = tpdCargoPkgs;
	}

	@Override
	public String toString() {
		return "Cargoes [reeferTempratureCelsius=" + reeferTempratureCelsius + ", weightLbs=" + weightLbs
				+ ", freightPaymentMethod=" + freightPaymentMethod + ", tpdFumigationDetails=" + tpdFumigationDetails
				+ ", description=" + description + ", tpdCargoHscodes=" + tpdCargoHscodes + ", updatedDate="
				+ updatedDate + ", tpdEqpStuffings=" + tpdEqpStuffings + ", measureCbm=" + measureCbm
				+ ", parentInstanceId=" + parentInstanceId + ", sequence=" + sequence + ", cargoId=" + cargoId
				+ ", hsCodes=" + hsCodes + ", instanceId=" + instanceId + ", createdDate=" + createdDate
				+ ", weightKgs=" + weightKgs + ", weightPricingLbs=" + weightPricingLbs + ", tpdDngrsDetails="
				+ tpdDngrsDetails + ", marsCode=" + marsCode + ", weightPricingKgs=" + weightPricingKgs
				+ ", tpdCargoPkgs=" + tpdCargoPkgs + "]";
	}

   

}
