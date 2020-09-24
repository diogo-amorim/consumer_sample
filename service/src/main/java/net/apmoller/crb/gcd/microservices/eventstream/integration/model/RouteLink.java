package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class RouteLink {
	
	 private String isOutOfContractScope;

	    private RouteStartPoint routeStartPoint;

	    private String serviceCode;

	    private String etdLocal;

	    private String RKSTCarrierCode;

	    private String updateTime;

	    private String etaLocal;

	    private String departureTimeUTCExpected;

	    private RouteEndPoint routeEndPoint;

	    private String arrivalTimeUTCExpected;

	    private String createTime;

	    private String exportVoyage;

	    private String transportMode;

	    private String waterLandMode;

	    private String vesselCode;

	    private String importVoyage;

	    public String getIsOutOfContractScope ()
	    {
	        return isOutOfContractScope;
	    }

	    public void setIsOutOfContractScope (String isOutOfContractScope)
	    {
	        this.isOutOfContractScope = isOutOfContractScope;
	    }

	    public RouteStartPoint getRouteStartPoint ()
	    {
	        return routeStartPoint;
	    }

	    public void setRouteStartPoint (RouteStartPoint routeStartPoint)
	    {
	        this.routeStartPoint = routeStartPoint;
	    }

	    public String getServiceCode ()
	    {
	        return serviceCode;
	    }

	    public void setServiceCode (String serviceCode)
	    {
	        this.serviceCode = serviceCode;
	    }

	    public String getEtdLocal ()
	    {
	        return etdLocal;
	    }

	    public void setEtdLocal (String etdLocal)
	    {
	        this.etdLocal = etdLocal;
	    }

	    public String getRKSTCarrierCode ()
	    {
	        return RKSTCarrierCode;
	    }

	    public void setRKSTCarrierCode (String RKSTCarrierCode)
	    {
	        this.RKSTCarrierCode = RKSTCarrierCode;
	    }

	    public String getUpdateTime ()
	    {
	        return updateTime;
	    }

	    public void setUpdateTime (String updateTime)
	    {
	        this.updateTime = updateTime;
	    }

	    public String getEtaLocal ()
	    {
	        return etaLocal;
	    }

	    public void setEtaLocal (String etaLocal)
	    {
	        this.etaLocal = etaLocal;
	    }

	    public String getDepartureTimeUTCExpected ()
	    {
	        return departureTimeUTCExpected;
	    }

	    public void setDepartureTimeUTCExpected (String departureTimeUTCExpected)
	    {
	        this.departureTimeUTCExpected = departureTimeUTCExpected;
	    }

	    public RouteEndPoint getRouteEndPoint ()
	    {
	        return routeEndPoint;
	    }

	    public void setRouteEndPoint (RouteEndPoint routeEndPoint)
	    {
	        this.routeEndPoint = routeEndPoint;
	    }

	    public String getArrivalTimeUTCExpected ()
	    {
	        return arrivalTimeUTCExpected;
	    }

	    public void setArrivalTimeUTCExpected (String arrivalTimeUTCExpected)
	    {
	        this.arrivalTimeUTCExpected = arrivalTimeUTCExpected;
	    }

	    public String getCreateTime ()
	    {
	        return createTime;
	    }

	    public void setCreateTime (String createTime)
	    {
	        this.createTime = createTime;
	    }

	    public String getExportVoyage ()
	    {
	        return exportVoyage;
	    }

	    public void setExportVoyage (String exportVoyage)
	    {
	        this.exportVoyage = exportVoyage;
	    }

	    public String getTransportMode ()
	    {
	        return transportMode;
	    }

	    public void setTransportMode (String transportMode)
	    {
	        this.transportMode = transportMode;
	    }

	    public String getWaterLandMode ()
	    {
	        return waterLandMode;
	    }

	    public void setWaterLandMode (String waterLandMode)
	    {
	        this.waterLandMode = waterLandMode;
	    }

	    public String getVesselCode ()
	    {
	        return vesselCode;
	    }

	    public void setVesselCode (String vesselCode)
	    {
	        this.vesselCode = vesselCode;
	    }

	    public String getImportVoyage ()
	    {
	        return importVoyage;
	    }

	    public void setImportVoyage (String importVoyage)
	    {
	        this.importVoyage = importVoyage;
	    }

		@Override
		public String toString() {
			return "RouteLink [isOutOfContractScope=" + isOutOfContractScope + ", routeStartPoint=" + routeStartPoint
					+ ", serviceCode=" + serviceCode + ", etdLocal=" + etdLocal + ", RKSTCarrierCode=" + RKSTCarrierCode
					+ ", updateTime=" + updateTime + ", etaLocal=" + etaLocal + ", departureTimeUTCExpected="
					+ departureTimeUTCExpected + ", routeEndPoint=" + routeEndPoint + ", arrivalTimeUTCExpected="
					+ arrivalTimeUTCExpected + ", createTime=" + createTime + ", exportVoyage=" + exportVoyage
					+ ", transportMode=" + transportMode + ", waterLandMode=" + waterLandMode + ", vesselCode="
					+ vesselCode + ", importVoyage=" + importVoyage + "]";
		}

	    
	    
}
