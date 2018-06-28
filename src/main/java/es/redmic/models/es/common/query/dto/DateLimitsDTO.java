package es.redmic.models.es.common.query.dto;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.constraintvalidate.daterange.ValidateDateRange;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@ValidateDateRange(start="startDate", end="endDate")
public class DateLimitsDTO {
	
	DateTime startDate;

	DateTime endDate;

	public DateLimitsDTO() {
	}

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
}