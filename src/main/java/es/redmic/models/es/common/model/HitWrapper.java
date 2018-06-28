package es.redmic.models.es.common.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HitWrapper {
	
	private String _index;
	
	private String _type;
	
	private String _id;
	
	private Double _score;
	
	private Long _version;
	
	private Map<String, Object> highlight;

	public String get_index() {
		return _index;
	}

	public void set_index(String _index) {
		this._index = _index;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Double get_score() {
		return _score;
	}

	public void set_score(Double _score) {
		this._score = _score;
	}

	public Long get_version() {
		return _version;
	}

	public void set_version(Long _version) {
		this._version = _version;
	}

	public Map<String, Object> getHighlight() {
		return highlight;
	}

	public void setHighlight(Map<String, Object> highlight) {
		this.highlight = highlight;
		processHighLigh();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void processHighLigh() {
		
		
		Map<String, Object> highlight_temp = new HashMap<String, Object>();
		
		if (highlight == null)
			return;
		
		Iterator<?> it = highlight.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Object> entry = (Map.Entry)it.next();
	        
			if (entry.getKey().contains("suggest")) {
		    	String key = entry.getKey().replace(".suggest", "");
		    	Object value = entry.getValue();
		    	it.remove();
		    
		    	if (!highlight.containsKey(key)) {
		    		highlight_temp.put(key, value);
		    	}
		    }
		}
	    
	    highlight.putAll(highlight_temp);
	}
}