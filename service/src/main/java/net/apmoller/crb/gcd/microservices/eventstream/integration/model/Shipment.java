package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class Shipment {
	
	    private String isDangerous;

	    private String shipmentVersionInstance;

	    private String shipmentClass;

	    private List<Cargoes> cargoes;

	    private String lineCode;

	    private String receiptDeliveryMode;

	    private List<Routes> routes;

	    private List<Equipments> equipments;

	    private String cargoDeliveryTimeLocal;

	    private String receiptCargoMode;

	    private String shipmentId;

	    private String businessUnitCode;

	    private List<Parties> parties;

	    private String cargoReadyTimeLocal;

	    private String businessAddress;

		public String getIsDangerous() {
			return isDangerous;
		}

		public void setIsDangerous(String isDangerous) {
			this.isDangerous = isDangerous;
		}

		public String getShipmentVersionInstance() {
			return shipmentVersionInstance;
		}

		public void setShipmentVersionInstance(String shipmentVersionInstance) {
			this.shipmentVersionInstance = shipmentVersionInstance;
		}

		public String getShipmentClass() {
			return shipmentClass;
		}

		public void setShipmentClass(String shipmentClass) {
			this.shipmentClass = shipmentClass;
		}

		public List<Cargoes> getCargoes() {
			return cargoes;
		}

		public void setCargoes(List<Cargoes> cargoes) {
			this.cargoes = cargoes;
		}

		public String getLineCode() {
			return lineCode;
		}

		public void setLineCode(String lineCode) {
			this.lineCode = lineCode;
		}

		public String getReceiptDeliveryMode() {
			return receiptDeliveryMode;
		}

		public void setReceiptDeliveryMode(String receiptDeliveryMode) {
			this.receiptDeliveryMode = receiptDeliveryMode;
		}

		public List<Routes> getRoutes() {
			return routes;
		}

		public void setRoutes(List<Routes> routes) {
			this.routes = routes;
		}

		public List<Equipments> getEquipments() {
			return equipments;
		}

		public void setEquipments(List<Equipments> equipments) {
			this.equipments = equipments;
		}

		public String getCargoDeliveryTimeLocal() {
			return cargoDeliveryTimeLocal;
		}

		public void setCargoDeliveryTimeLocal(String cargoDeliveryTimeLocal) {
			this.cargoDeliveryTimeLocal = cargoDeliveryTimeLocal;
		}

		public String getReceiptCargoMode() {
			return receiptCargoMode;
		}

		public void setReceiptCargoMode(String receiptCargoMode) {
			this.receiptCargoMode = receiptCargoMode;
		}

		public String getShipmentId() {
			return shipmentId;
		}

		public void setShipmentId(String shipmentId) {
			this.shipmentId = shipmentId;
		}

		public String getBusinessUnitCode() {
			return businessUnitCode;
		}

		public void setBusinessUnitCode(String businessUnitCode) {
			this.businessUnitCode = businessUnitCode;
		}

		public List<Parties> getParties() {
			return parties;
		}

		public void setParties(List<Parties> parties) {
			this.parties = parties;
		}

		public String getCargoReadyTimeLocal() {
			return cargoReadyTimeLocal;
		}

		public void setCargoReadyTimeLocal(String cargoReadyTimeLocal) {
			this.cargoReadyTimeLocal = cargoReadyTimeLocal;
		}

		public String getBusinessAddress() {
			return businessAddress;
		}

		public void setBusinessAddress(String businessAddress) {
			this.businessAddress = businessAddress;
		}

		@Override
		public String toString() {
			return "Shipment [isDangerous=" + isDangerous + ", shipmentVersionInstance=" + shipmentVersionInstance
					+ ", shipmentClass=" + shipmentClass + ", cargoes=" + cargoes + ", lineCode=" + lineCode
					+ ", receiptDeliveryMode=" + receiptDeliveryMode + ", routes=" + routes + ", equipments="
					+ equipments + ", cargoDeliveryTimeLocal=" + cargoDeliveryTimeLocal + ", receiptCargoMode="
					+ receiptCargoMode + ", shipmentId=" + shipmentId + ", businessUnitCode=" + businessUnitCode
					+ ", parties=" + parties + ", cargoReadyTimeLocal=" + cargoReadyTimeLocal + ", businessAddress="
					+ businessAddress + "]";
		}

	    
}
