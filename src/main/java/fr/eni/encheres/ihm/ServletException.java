package fr.eni.encheres.ihm;

@SuppressWarnings("serial")
public class ServletException extends Exception {
	public ServletException() {
		super();
	}
	
	public ServletException(String message) {
		super(message);
	}
	
	public ServletException(String message, Throwable exception) {
		super(message, exception);
	}

	//Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
}
