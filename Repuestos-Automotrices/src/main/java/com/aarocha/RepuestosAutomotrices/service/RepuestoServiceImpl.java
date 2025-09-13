package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Repuesto;
import com.aarocha.RepuestosAutomotrices.repository.RepuestoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImpl(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAllRepuestos() {
        return repuestoRepository.findAll();
    }

    @Override
    public Repuesto getRepuestoById(Integer id) {
        return repuestoRepository.findById(id).orElse(null);
    }

    @Override
    public Repuesto saveRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    @Override
    public Repuesto updateRepuesto(Integer id, Repuesto repuesto) {
        Repuesto existente = repuestoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombreRepuesto(repuesto.getNombreRepuesto());
            existente.setMarca(repuesto.getMarca());
            existente.setPrecio(repuesto.getPrecio());
            existente.setStock(repuesto.getStock());
            return repuestoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteRepuesto(Integer id) {
        repuestoRepository.deleteById(id);
    }
}
