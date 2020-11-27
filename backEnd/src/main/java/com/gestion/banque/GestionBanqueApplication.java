package com.gestion.banque;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gestion.banque.dao.ClientRepository;
import com.gestion.banque.dao.CompteRepository;
import com.gestion.banque.dao.OperationRepository;
import com.gestion.banque.entity.Client;
import com.gestion.banque.entity.CompteCourant;
import com.gestion.banque.services.IBanqueService;

@SpringBootApplication
public class GestionBanqueApplication  {

	@Autowired
	ClientRepository secondClientRepository;
	@Autowired
	CompteRepository secondCompteRepository;
	@Autowired
	OperationRepository secondOperationRepository;	
	@Autowired
	IBanqueService banqueServices;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestionBanqueApplication.class, args);
		CompteRepository secondCompteRepository = ctx.getBean(CompteRepository.class);
		ClientRepository clientRepository = ctx.getBean(ClientRepository.class);
		Client client = clientRepository.save(new Client("hatim", "hatim@gmail.com"));
		secondCompteRepository.save(new CompteCourant(new Date(), 900, client, 600));
	}
	
//	@Bean
//	CommandLineRunner start() {
//		return args -> {
//			Client client = secondClientRepository.save(new Client("boudabza", "boudabza@gmail.com"));
//			Client client2 = secondClientRepository.save(new Client("ali", "ali@gmail.com"));
//			Compte compte1 = secondCompteRepository.save(new CompteCourant("c1", new Date(), 900, client, 600));
//			Compte compte2 = secondCompteRepository.save(new CompteEpargne("c2", new Date(), 1300, client2, 2));
////			Operation operation1 = secondOperationRepository.save(new Versement(new Date(), 60000, compte1));
////			Operation operation2 = secondOperationRepository.save(new Retrait(new Date(), 30000, compte2));		
//			banqueServices.verser("c1", 100);
//			banqueServices.virement("c2","c1", 200);
//		};
//	}

}
