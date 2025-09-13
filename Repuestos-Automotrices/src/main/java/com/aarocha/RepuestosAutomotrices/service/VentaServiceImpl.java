package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Venta;
import com.aarocha.RepuestosAutomotrices.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;

    public VentaServiceImpl(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Integer idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }

    @Override
    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta updateVenta(Integer idVenta, Venta venta) {
        Venta existente = ventaRepository.findById(idVenta).orElse(null);
        if (existente != null) {
            existente.setFechaVenta(venta.getFechaVenta());
            existente.setCliente(venta.getCliente());
            existente.setRepuesto(venta.getRepuesto());
            existente.setCantidad(venta.getCantidad());
            existente.setTotal(venta.getTotal()); // BigDecimal
            return ventaRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}
