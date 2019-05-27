public class Salle {

	private int id;
	private String nom;
	private String adresse;
	private int etage;
	private String type;
	private int digicode;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Salle(int id, String nom, String adresse,String type, int etage, int digicode) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.etage = etage;
		this.type = type;
		this.digicode = digicode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDigicode() {
		return digicode;
	}
	public void setDigicode(int digicode) {
		this.digicode = digicode;
	}
	
	@Override
	public String toString() {
		return this.getNom();
	}
	

}
