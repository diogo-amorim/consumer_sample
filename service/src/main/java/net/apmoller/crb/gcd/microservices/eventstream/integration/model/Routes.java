package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

public class Routes {

	 private String instanceId;

	    private String createdDate;

	    private List<RouteLink> routeLink;

	    private String updatedDate;

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

		public List<RouteLink> getRouteLink() {
			return routeLink;
		}

		public void setRouteLink(List<RouteLink> routeLink) {
			this.routeLink = routeLink;
		}

		public String getUpdatedDate() {
			return updatedDate;
		}

		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}

		@Override
		public String toString() {
			return "Routes [instanceId=" + instanceId + ", createdDate=" + createdDate + ", routeLink=" + routeLink
					+ ", updatedDate=" + updatedDate + "]";
		}

	   
	
}
