package com.gestion.banque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.banque.dao.ClientRepository;
import com.gestion.banque.entity.Client;
import com.gestion.banque.services.IBanqueService;

@RestController
public class BanqueController {

	@Autowired
	IBanqueService banqueService;
	@Autowired
	ClientRepository compteRepository;
	@GetMapping("/consulter")
	@ResponseBody
	public List<Client> consulterCompte() {
		return compteRepository.findAll();
		//return banqueService.consulterCompte("c1");
	}
}
