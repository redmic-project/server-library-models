package es.redmic.models.es.common.utils;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class HierarchicalUtils {


	public static List<String> getIdsFromPaths(List<String> paths) {

		List<String> ids = new ArrayList<String>();
		for (int i=0; i<paths.size(); i++)
			ids.add(getIdFromPath(paths.get(i)));
		return ids;
	}

	public static String getIdFromPath(String path) {

		String[] pathSplit = path.split("\\.");
		return pathSplit[pathSplit.length -1];
	}

	public static String getParentPath(String path) {

		return getAncestorPath(path, 2);
	}

	public static String getAncestorPath(String path, Integer ancestorPos) {

		String[] pathSplit = path.split("\\.");
		String[] pathSplitResult = Arrays.copyOf(pathSplit, pathSplit.length - ancestorPos);
		return StringUtils.join(pathSplitResult, ".");
	}


	/**
	 * Función para obtener el id del padre a partir del path.
	 *
	 * @param path string que se compone de los identificadores de los ancestors y el suyo propio, unidos por punto.
	 * @return string con el identificador del padre.
	 */

	public static String getParentId(String path) {

		String[] ancestorIds = getAncestorsIds(path);
		if(ancestorIds == null || ancestorIds.length == 0)
			return null;
		return ancestorIds[ancestorIds.length - 1];
	}

	/**
	 * Función para obtener el id del abuelo a partir del path.
	 *
	 * @param path string que se compone de los identificadores de los ancestors y el suyo propio, unidos por punto.
	 * @return string con el identificador del abuelo.
	 */

	public static String getGrandparentId(String path) {

		String[] ancestorIds = getAncestorsIds(path);
		if(ancestorIds == null || ancestorIds.length < 3)
			return null;
		return ancestorIds[ancestorIds.length - 2];
	}

	/**
	 * Función para obtener los ids de los ancestors a partir del path.
	 *
	 * @param path string que se compone de los identificadores de los ancestors y el suyo propio, unidos por punto.
	 * @return array de identificadores de los ancestors sin contar el suyo.
	 */

	public static String[] getAncestorsIds(String path) {

		String[] pathSplitted = path.split("\\.");
		if (pathSplitted.length > 2)
			return (String[]) Arrays.copyOfRange(pathSplitted, 1, pathSplitted.length - 1);
		return null;
	}

	/**
	 * Función para obtener los paths de los ancestors incluido el suyo a partir del path.
	 *
	 * @param path string que se compone de los identificadores de los ancestors y el suyo propio, unidos por punto.
	 * @return lista de paths.
	 */

	public static List<String> getAncestorsAndChildPaths(String path) {

		String[] pathSplitted = path.split("\\.");
		List<String> paths = new ArrayList<String>();

		for (int i=0; i<pathSplitted.length-1; i++) {
			 paths.add(getSubPath(pathSplitted, pathSplitted.length - i));
		}
		return paths;
	}

	public static List<String> getAncestorsPaths(String path) {

		List<String> paths = getAncestorsAndChildPaths(path);
		paths.remove(path);
		return paths;
	}

	public static List<String> getAncestorsPathsByLevel(String path, Integer level) {

		String[] pathSplitted = path.split("\\.");
		List<String> paths = new ArrayList<String>();

		for (int i=0; i<pathSplitted.length-2; i++) {
			String newPath = getSubPath(pathSplitted, pathSplitted.length - i);
			if (newPath.split("\\.").length > level)
				paths.add(newPath);
		}
		return paths;
	}

	public static String getSubPath(String[] pathSplitted, int level) {

		return StringUtils.join(Arrays.copyOfRange(pathSplitted, 0, level), ".");
	}
}
