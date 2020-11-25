package com.gestion.banque.services;

import org.springframework.data.domain.Page;

import com.gestion.banque.entity.Compte;
import com.gestion.banque.entity.Operation;
//Besoin Fonctionnelle de l'application à partir de notre diagramme cas d'utilisation
public interface IBanqueService {
	
	public Compte consulterCompte(String codeCompte);
	public void verser(String CodeCompte,double montant);
	public void retirer(String CodeCompte,double montant);
	public void virement(String CodeCompteSource,String CodeCompteDestinataire,double montant);
	//c'est mieux de créer class Page de notre application et ne pas utilisé pagination de spring data
	//gerer la pagination
	public Page<Operation> listeOperation(String codeCompte,int page , int size); 
}
