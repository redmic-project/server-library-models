package es.redmic.models.es.geojson.tracking.common.linestring;

import java.util.ArrayList;
import java.util.List;

import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.tracking.common.point.ClusterPointPropertiesDTO;

public class ClusterLineStringPropertiesDTO extends ClusterPointPropertiesDTO {

	List<ClusterPropertiesDTO> axesProps = new ArrayList<ClusterPropertiesDTO>();

	public List<ClusterPropertiesDTO> getAxesProps() {
		return axesProps;
	}

	public void setAxesProps(List<ClusterPropertiesDTO> axesProps) {
		this.axesProps = axesProps;
	}

}
