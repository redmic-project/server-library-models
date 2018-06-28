package es.redmic.models.es.geojson.tracking.common;

public class TrackingClusterCollectionDTO {

	private TrackingClustersDTO clusterList;
	private Long itemsInvolved;


	public TrackingClusterCollectionDTO() {
		
	}

	public TrackingClustersDTO getClusterList() {
		return clusterList;
	}

	public void setClusterList(TrackingClustersDTO clusterList) {
		this.clusterList = clusterList;
		setItemsInvolved(clusterList.getItemsInvolved());
	}

	public Long getItemsInvolved() {
		return itemsInvolved;
	}

	public void setItemsInvolved(Long itemsInvolved) {
		this.itemsInvolved = itemsInvolved;
	}
}
