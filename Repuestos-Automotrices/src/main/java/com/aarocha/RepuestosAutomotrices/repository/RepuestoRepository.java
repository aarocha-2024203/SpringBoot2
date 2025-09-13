package com.aarocha.RepuestosAutomotrices.repository;

import com.aarocha.RepuestosAutomotrices.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {
}
