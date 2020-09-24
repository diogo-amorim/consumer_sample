package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.Arrays;

public class TpdCargoPkgs {

	private String packageStyleAltText;

	private String instanceId;

	private String createdDate;

	private String packageDescriptionType;

	private String cargoPackageId;

	private TpdCargoPkgTypes[] tpdCargoPkgTypes;

	private String packageCount;

	private String updatedDate;

	private String packageStyle;

	public String getPackageStyleAltText() {
		return packageStyleAltText;
	}

	public void setPackageStyleAltText(String packageStyleAltText) {
		this.packageStyleAltText = packageStyleAltText;
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

	public String getPackageDescriptionType() {
		return packageDescriptionType;
	}

	public void setPackageDescriptionType(String packageDescriptionType) {
		this.packageDescriptionType = packageDescriptionType;
	}

	public String getCargoPackageId() {
		return cargoPackageId;
	}

	public void setCargoPackageId(String cargoPackageId) {
		this.cargoPackageId = cargoPackageId;
	}

	public TpdCargoPkgTypes[] getTpdCargoPkgTypes() {
		return tpdCargoPkgTypes;
	}

	public void setTpdCargoPkgTypes(TpdCargoPkgTypes[] tpdCargoPkgTypes) {
		this.tpdCargoPkgTypes = tpdCargoPkgTypes;
	}

	public String getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(String packageCount) {
		this.packageCount = packageCount;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getPackageStyle() {
		return packageStyle;
	}

	public void setPackageStyle(String packageStyle) {
		this.packageStyle = packageStyle;
	}

	@Override
	public String toString() {
		return "TpdCargoPkgs [packageStyleAltText=" + packageStyleAltText + ", instanceId=" + instanceId
				+ ", createdDate=" + createdDate + ", packageDescriptionType=" + packageDescriptionType
				+ ", cargoPackageId=" + cargoPackageId + ", tpdCargoPkgTypes=" + Arrays.toString(tpdCargoPkgTypes)
				+ ", packageCount=" + packageCount + ", updatedDate=" + updatedDate + ", packageStyle=" + packageStyle
				+ "]";
	}

	
	
}
