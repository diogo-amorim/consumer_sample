package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class RouteEndPoint {

	 private String pointSequence;

	    private String createTime;

	    private String rkstCode;

	    private String rkstCityCode;

	    private String geoCode;

	    private String siteName;

	    private String updateTime;

	    private String customsLocationCode;

	    public String getPointSequence ()
	    {
	        return pointSequence;
	    }

	    public void setPointSequence (String pointSequence)
	    {
	        this.pointSequence = pointSequence;
	    }

	    public String getCreateTime ()
	    {
	        return createTime;
	    }

	    public void setCreateTime (String createTime)
	    {
	        this.createTime = createTime;
	    }

	    public String getRkstCode ()
	    {
	        return rkstCode;
	    }

	    public void setRkstCode (String rkstCode)
	    {
	        this.rkstCode = rkstCode;
	    }

	    public String getRkstCityCode ()
	    {
	        return rkstCityCode;
	    }

	    public void setRkstCityCode (String rkstCityCode)
	    {
	        this.rkstCityCode = rkstCityCode;
	    }

	    public String getGeoCode ()
	    {
	        return geoCode;
	    }

	    public void setGeoCode (String geoCode)
	    {
	        this.geoCode = geoCode;
	    }

	    public String getSiteName ()
	    {
	        return siteName;
	    }

	    public void setSiteName (String siteName)
	    {
	        this.siteName = siteName;
	    }

	    public String getUpdateTime ()
	    {
	        return updateTime;
	    }

	    public void setUpdateTime (String updateTime)
	    {
	        this.updateTime = updateTime;
	    }

	    public String getCustomsLocationCode ()
	    {
	        return customsLocationCode;
	    }

	    public void setCustomsLocationCode (String customsLocationCode)
	    {
	        this.customsLocationCode = customsLocationCode;
	    }

		@Override
		public String toString() {
			return "RouteEndPoint [pointSequence=" + pointSequence + ", createTime=" + createTime + ", rkstCode="
					+ rkstCode + ", rkstCityCode=" + rkstCityCode + ", geoCode=" + geoCode + ", siteName=" + siteName
					+ ", updateTime=" + updateTime + ", customsLocationCode=" + customsLocationCode + "]";
		}

	
	    
}
