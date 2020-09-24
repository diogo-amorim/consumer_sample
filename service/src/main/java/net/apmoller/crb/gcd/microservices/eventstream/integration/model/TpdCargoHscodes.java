package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class TpdCargoHscodes {

	private String hscodeId;

	private String hscode;

	private String packageKind;

	private String quantity;

	private String instanceId;

	private String weightKgs;

	public String getHscodeId() {
		return hscodeId;
	}

	public void setHscodeId(String hscodeId) {
		this.hscodeId = hscodeId;
	}

	public String getHscode() {
		return hscode;
	}

	public void setHscode(String hscode) {
		this.hscode = hscode;
	}

	public String getPackageKind() {
		return packageKind;
	}

	public void setPackageKind(String packageKind) {
		this.packageKind = packageKind;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getWeightKgs() {
		return weightKgs;
	}

	public void setWeightKgs(String weightKgs) {
		this.weightKgs = weightKgs;
	}

	@Override
	public String toString() {
		return "TpdCargoHscodes [hscodeId=" + hscodeId + ", hscode=" + hscode + ", packageKind=" + packageKind
				+ ", quantity=" + quantity + ", instanceId=" + instanceId + ", weightKgs=" + weightKgs + "]";
	}

	
}
