package com.gestion.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.banque.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
