package fr.eni.encheres.bo;

import java.sql.Date;

public class Enchere {
	private Date dateEnchere;
	private float montant_enchere;
	//constructor
	public Enchere () {
		
}
	public Enchere(Date dateEnchere, float montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}
	// getter and setter
	public Date getdateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchère(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
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
		return "Enchère [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + "]";
	}
	
	}