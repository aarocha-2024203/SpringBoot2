package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Venta;
import java.util.List;

public interface VentaService {
    List<Venta> getAllVentas();
    Venta getVentaById(Integer idVenta);
    Venta saveVenta(Venta venta);
    Venta updateVenta(Integer idVenta, Venta venta);
    void deleteVenta(Integer idVenta);
}

