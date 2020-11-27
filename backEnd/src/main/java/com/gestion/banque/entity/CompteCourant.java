package com.gestion.banque.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(Date dateCreation, double solde, Client client,double decouvert) {
		super(dateCreation, solde,client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
