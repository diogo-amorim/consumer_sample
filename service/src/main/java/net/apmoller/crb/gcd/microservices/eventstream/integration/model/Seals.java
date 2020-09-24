package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

public class Seals {

	  private String sealName;

	    private String createdDate;

	    private String sealNumber;

	    private String updatedDate;

	    public String getSealName ()
	    {
	        return sealName;
	    }

	    public void setSealName (String sealName)
	    {
	        this.sealName = sealName;
	    }

	    public String getCreatedDate ()
	    {
	        return createdDate;
	    }

	    public void setCreatedDate (String createdDate)
	    {
	        this.createdDate = createdDate;
	    }

	    public String getSealNumber ()
	    {
	        return sealNumber;
	    }

	    public void setSealNumber (String sealNumber)
	    {
	        this.sealNumber = sealNumber;
	    }

	    public String getUpdatedDate ()
	    {
	        return updatedDate;
	    }

	    public void setUpdatedDate (String updatedDate)
	    {
	        this.updatedDate = updatedDate;
	    }

		@Override
		public String toString() {
			return "Seals [sealName=" + sealName + ", createdDate=" + createdDate + ", sealNumber=" + sealNumber
					+ ", updatedDate=" + updatedDate + "]";
		}
	    
	    
	
}
