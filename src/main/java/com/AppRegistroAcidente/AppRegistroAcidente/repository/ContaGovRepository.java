package com.AppRegistroAcidente.AppRegistroAcidente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppRegistroAcidente.AppRegistroAcidente.models.ContaGov;

public interface ContaGovRepository extends JpaRepository<ContaGov, Long> {
	ContaGov findByUsuarioAndSenha(String usuario, String senha);
	
 
}
