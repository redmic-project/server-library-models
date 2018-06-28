package es.redmic.models.es.series.timeseries.dto;

import java.util.ArrayList;
import java.util.List;

public class WindroseDataDTO extends RangesOfSplitsDTO {

	private List<WindroseSectorDTO> data = new ArrayList<WindroseSectorDTO>();

	public List<WindroseSectorDTO> getData() {
		return data;
	}

	public void setData(List<WindroseSectorDTO> data) {
		this.data = data;
	}
	
	public void addSectorData(WindroseSectorDTO sectorData) {
		
		if (data == null)
			data = new ArrayList<WindroseSectorDTO>();
		data.add(sectorData);
	}
}
