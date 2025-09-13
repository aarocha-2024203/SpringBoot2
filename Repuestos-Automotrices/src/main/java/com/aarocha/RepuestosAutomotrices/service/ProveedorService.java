package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> getAllProveedores();
    Proveedor getProveedorById(Integer idProveedor);
    Proveedor saveProveedor(Proveedor proveedor);
    Proveedor updateProveedor(Integer idProveedor, Proveedor proveedor);
    void deleteProveedor(Integer idProveedor);
}
