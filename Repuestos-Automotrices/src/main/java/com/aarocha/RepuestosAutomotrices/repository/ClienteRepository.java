package com.aarocha.RepuestosAutomotrices.repository;

import com.aarocha.RepuestosAutomotrices.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
