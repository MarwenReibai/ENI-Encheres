package fr.eni.encheres.bo;
public class Categorie {
	private int noCategorie ;
	private String libelle;
	//constructor
	public Categorie () {
		
	}
	public Categorie(int noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	// getter and setter*
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	// to string
	@Override
	public java.lang.String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	

}
