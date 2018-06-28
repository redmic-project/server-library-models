package es.redmic.models.es.common.view;

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
		else if (roles.contains("ROLE_OAG"))
			return Administrative.class;
		else if (roles.contains("ROLE_COLLABORATOR"))
			return Collaborator.class;
		else if (roles.contains("ROLE_USER"))
			return User.class;
		else //if (roles.contains("ROLE_ANONYMOUS"))
			return Guest.class;
	}
}
