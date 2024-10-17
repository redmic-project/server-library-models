package es.redmic.models.es.common.view;

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

import java.util.List;

public class JsonViewsForQueryDTO {

	public static class Administrator extends Administrative {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(Administrator.class) || super.isAuthorized(viewClass);
		}
    }

	public static class Administrative extends Collaborator {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(Administrative.class) || super.isAuthorized(viewClass);
		}
    }

	public static class Collaborator extends Owner {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(Collaborator.class) || super.isAuthorized(viewClass);
		}
    }

	public static class Owner extends User {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(Owner.class) || super.isAuthorized(viewClass);
		}
    }

	public static class User extends Guest {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(User.class) || super.isAuthorized(viewClass);
		}
    }

	public static class Guest implements ViewClassInterface {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass) {
			return viewClass.equals(Guest.class);

		}
    }

	public static interface ViewClassInterface {

		public boolean isAuthorized(Class<ViewClassInterface> viewClass);
	}

	public static Class<?> getJsonView(List<String> roles) {

		if (roles.contains("ROLE_ADMINISTRATOR"))
			return Administrator.class;
		else if (roles.contains("ROLE_MANAGER"))
			return Administrative.class;
		else if (roles.contains("ROLE_COLLABORATOR"))
			return Collaborator.class;
		else if (roles.contains("ROLE_USER"))
			return User.class;
		else //if (roles.contains("ROLE_ANONYMOUS"))
			return Guest.class;
	}
}
