
public class User {
	private String login;
	private String mdp;
	private String grade;
	
	public User (String login, String mdp, String grade) {
		this.login = login;
		this.mdp = mdp;
		this.grade = grade;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String Grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return  login ;
	}
	
	public String toString2() {
		return  mdp ;
	}
	
}
