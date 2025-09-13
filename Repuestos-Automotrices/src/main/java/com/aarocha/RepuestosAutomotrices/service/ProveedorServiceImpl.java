package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Proveedor;
import com.aarocha.RepuestosAutomotrices.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getProveedorById(Integer idProveedor) {
        return proveedorRepository.findById(idProveedor).orElse(null);
    }

    @Override
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Integer idProveedor, Proveedor proveedor) {
        Proveedor existente = proveedorRepository.findById(idProveedor).orElse(null);
        if (existente != null) {
            existente.setNombreProveedor(proveedor.getNombreProveedor());
            existente.setTelefono(proveedor.getTelefono());
            existente.setDireccion(proveedor.getDireccion());
            return proveedorRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteProveedor(Integer idProveedor) {
        proveedorRepository.deleteById(idProveedor);
    }
}
