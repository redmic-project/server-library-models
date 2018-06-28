package es.redmic.models.birt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Birt {

	@SuppressWarnings("rawtypes")
	Iterator iterator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void open(Object appContext, Map params) {

		Map<String, Object> app = (Map<String, Object>) appContext;
		ArrayList items = (ArrayList) app.get("data");

		if (items == null)
			items = new ArrayList();

		iterator = items.iterator();
	}

	public Object next() {

		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public void close() {

		iterator = null;
	}
}
