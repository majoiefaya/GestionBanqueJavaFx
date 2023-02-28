package model;
import java.sql.Date;

public class Compte {
	
	String type;
	Integer numero,valeur,taux_epargne;
	
	
	public Compte() {
		
	}

	public Compte(int numero ,String type,int valeur) {
		this.numero=numero;
		this.valeur=valeur;
		this.type=type;
	}

	public Compte(int numero ,String type,int taux_epargne,int valeur) {
		this.numero=numero;
		this.valeur=valeur;
		this.type=type;
		this.taux_epargne=taux_epargne;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public Integer getTaux_epargne() {
		return taux_epargne;
	}

	public void setTaux_epargne(Integer taux_epargne) {
		this.taux_epargne = taux_epargne;
	}

	
	
	
}
