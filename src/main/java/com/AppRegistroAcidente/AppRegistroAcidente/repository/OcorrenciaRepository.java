package com.AppRegistroAcidente.AppRegistroAcidente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

}
