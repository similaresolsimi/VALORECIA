package com.site.obj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class user {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String pswd;
	
	public user(){
		
	}
	
	public user(String pseu, String mdp){
		pseudo= pseu;
		pswd=mdp;
	}
	
 	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {

		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
}
