package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class TpdFumigationDetails {
	
	    private String isFinestLevel;

	    private String packageStyleAltText;

	    private String weightNetKgs;

	    private String instanceId;

	    private String createdDate;

	    private String unNumber;

	    private String fumigationDetailsId;

	    private String imoClassification;

	    private String weightGrossKgs;

	    private String updatedDate;

	    private String packageCount;

	    public String getIsFinestLevel ()
	    {
	        return isFinestLevel;
	    }

	    public void setIsFinestLevel (String isFinestLevel)
	    {
	        this.isFinestLevel = isFinestLevel;
	    }

	    public String getPackageStyleAltText ()
	    {
	        return packageStyleAltText;
	    }

	    public void setPackageStyleAltText (String packageStyleAltText)
	    {
	        this.packageStyleAltText = packageStyleAltText;
	    }

	    public String getWeightNetKgs ()
	    {
	        return weightNetKgs;
	    }

	    public void setWeightNetKgs (String weightNetKgs)
	    {
	        this.weightNetKgs = weightNetKgs;
	    }

	    public String getInstanceId ()
	    {
	        return instanceId;
	    }

	    public void setInstanceId (String instanceId)
	    {
	        this.instanceId = instanceId;
	    }

	    public String getCreatedDate ()
	    {
	        return createdDate;
	    }

	    public void setCreatedDate (String createdDate)
	    {
	        this.createdDate = createdDate;
	    }

	    public String getUnNumber ()
	    {
	        return unNumber;
	    }

	    public void setUnNumber (String unNumber)
	    {
	        this.unNumber = unNumber;
	    }

	    public String getFumigationDetailsId ()
	    {
	        return fumigationDetailsId;
	    }

	    public void setFumigationDetailsId (String fumigationDetailsId)
	    {
	        this.fumigationDetailsId = fumigationDetailsId;
	    }

	    public String getImoClassification ()
	    {
	        return imoClassification;
	    }

	    public void setImoClassification (String imoClassification)
	    {
	        this.imoClassification = imoClassification;
	    }

	    public String getWeightGrossKgs ()
	    {
	        return weightGrossKgs;
	    }

	    public void setWeightGrossKgs (String weightGrossKgs)
	    {
	        this.weightGrossKgs = weightGrossKgs;
	    }

	    public String getUpdatedDate ()
	    {
	        return updatedDate;
	    }

	    public void setUpdatedDate (String updatedDate)
	    {
	        this.updatedDate = updatedDate;
	    }

	    public String getPackageCount ()
	    {
	        return packageCount;
	    }

	    public void setPackageCount (String packageCount)
	    {
	        this.packageCount = packageCount;
	    }

		@Override
		public String toString() {
			return "TpdFumigationDetails [isFinestLevel=" + isFinestLevel + ", packageStyleAltText="
					+ packageStyleAltText + ", weightNetKgs=" + weightNetKgs + ", instanceId=" + instanceId
					+ ", createdDate=" + createdDate + ", unNumber=" + unNumber + ", fumigationDetailsId="
					+ fumigationDetailsId + ", imoClassification=" + imoClassification + ", weightGrossKgs="
					+ weightGrossKgs + ", updatedDate=" + updatedDate + ", packageCount=" + packageCount + "]";
		}

	    

}
