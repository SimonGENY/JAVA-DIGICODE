
public class log {
	
	private String login;
	private String heured;
	private String heuref;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getHeured() {
		return heured;
	}
	public void setHeured(String heured) {
		this.heured = heured;
	}
	
	public String getHeuref() {
		return heuref;
	}
	public void setHeuref(String heuref) {
		this.heuref = heuref;
	}
	
	public log (String login, String heured, String heuref) {
		this.login = login;
		this.heured = heured;
		this.heuref = heuref;
	}
	
	public String toString() {
		return  login ;
	}
	
}
