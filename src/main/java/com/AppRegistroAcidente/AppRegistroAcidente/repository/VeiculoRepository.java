package com.AppRegistroAcidente.AppRegistroAcidente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppRegistroAcidente.AppRegistroAcidente.models.Veiculo;

public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {

}
