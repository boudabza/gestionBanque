package com.gestion.banque.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.banque.dao.CompteRepository;
import com.gestion.banque.dao.OperationRepository;
import com.gestion.banque.entity.Compte;
import com.gestion.banque.entity.CompteCourant;
import com.gestion.banque.entity.Operation;
import com.gestion.banque.entity.Retrait;
import com.gestion.banque.entity.Versement;

@Service
@Transactional
public class BanqueServiceImp implements IBanqueService {

	@Autowired
	CompteRepository compteRepository;

	@Autowired
	OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCompte) {
		Compte compte = compteRepository.findById(codeCompte).orElse(null);
		if (compte == null)
			throw new RuntimeException("compte introuvable");
		return compte;
	}

	@Override
	public void verser(String CodeCompte, double montant) {
		Compte cp = consulterCompte(CodeCompte);
		Versement versement = new Versement(new Date(), montant, cp);
		operationRepository.save(versement);
		cp.setSolde(montant + cp.getSolde());
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String CodeCompte, double montant) {
		Compte cp = consulterCompte(CodeCompte);
		double facilityCaisse = 0;
		if (cp instanceof CompteCourant) {
			facilityCaisse = ((CompteCourant) cp).getDecouvert();
		}
		if (facilityCaisse + cp.getSolde() < montant) {
			throw new RuntimeException("solde insufisant");
		}
		Retrait retrait = new Retrait(new Date(), montant, cp);
		operationRepository.save(retrait);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);

	}

	@Override
	public void virement(String CodeCompteSource, String CodeCompteDestinataire, double montant) {
		retirer(CodeCompteSource, montant);
		verser(CodeCompteDestinataire, montant);
	}

	@Override
	public Page<Operation> listeOperation(String codeCompte, int page, int size) {
		return operationRepository.listOperation(codeCompte, PageRequest.of(page, size));
	}

}
