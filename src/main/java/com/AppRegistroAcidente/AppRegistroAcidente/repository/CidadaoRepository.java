package com.AppRegistroAcidente.AppRegistroAcidente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Cidadao;

public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

}
