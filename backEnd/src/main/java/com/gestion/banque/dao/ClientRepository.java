package com.gestion.banque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.banque.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
