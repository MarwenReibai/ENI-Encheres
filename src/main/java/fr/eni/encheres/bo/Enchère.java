package fr.eni.encheres.bo;

import java.sql.Date;

public class Enchère {
	private Date dateEnchère;
	private float montant_enchere;
	//constructor
	public Enchère () {
		
}
	public Enchère(Date dateEnchère, float montant_enchere) {
		super();
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
	}
	// getter and setter
	public Date getDateEnchère() {
		return dateEnchère;
	}
	public void setDateEnchère(Date dateEnchère) {
		this.dateEnchère = dateEnchère;
	}
	public float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	//to string
	@Override
	public java.lang.String toString() {
		return "Enchère [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + "]";
	}
	
	}