package es.redmic.models.es.administrative.taxonomy.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WormsClassificationDTO extends WormsBaseDTO {

	ObjectMapper mapper = new ObjectMapper();

	WormsClassificationDTO child;

	@JsonAnySetter
	public void parseUnknownProperties(String name, Object value) {

		if (!(value instanceof ArrayList<?>))
			child = mapper.convertValue(value, WormsClassificationDTO.class);
	}

	@JsonIgnore
	public void setChild(WormsClassificationDTO child) {
		this.child = child;
	}

	@JsonIgnore
	public WormsClassificationDTO getChild() {
		return child;
	}

	@JsonIgnore
	public WormsClassificationDTO getItemByRank(String rank) {

		WormsClassificationDTO _child = getChild();
		while (_child != null) {
			if (_child.getRank().toLowerCase().equals(rank.toLowerCase())) {
				return _child;
			}
			_child = _child.getChild();
		}
		return null;
	}

	@JsonIgnore
	public WormsClassificationDTO getParentItemByAphia(Integer aphia) {

		WormsClassificationDTO _parent = this, _child = getChild();
		while (_child != null) {
			if (_child.getAphia().equals(aphia)) {
				return _parent;
			}
			_parent = _child;
			_child = _child.getChild();
		}
		return null;
	}
}
