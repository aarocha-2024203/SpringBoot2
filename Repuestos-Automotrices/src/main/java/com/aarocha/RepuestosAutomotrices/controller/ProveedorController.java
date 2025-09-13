package com.aarocha.RepuestosAutomotrices.controller;

import com.aarocha.RepuestosAutomotrices.model.Proveedor;
import com.aarocha.RepuestosAutomotrices.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedor> getAllProveedores(){
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{idProveedor}")
    public Proveedor getProveedorById(@PathVariable Integer idProveedor){
        return proveedorService.getProveedorById(idProveedor);
    }

    @PostMapping
    public ResponseEntity<?> createProveedor(@RequestBody Proveedor proveedor){
        if (proveedor.getNombreProveedor() == null || proveedor.getNombreProveedor().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo nombreProveedor está vacío");
        }
        Proveedor savedProveedor = proveedorService.saveProveedor(proveedor);
        return ResponseEntity.ok(savedProveedor);
    }

    @PutMapping("/{idProveedor}")
    public Proveedor updateProveedor(@PathVariable Integer idProveedor, @RequestBody Proveedor proveedor){
        return proveedorService.updateProveedor(idProveedor, proveedor);
    }

    @DeleteMapping("/{idProveedor}")
    public void deleteProveedor(@PathVariable Integer idProveedor){
        proveedorService.deleteProveedor(idProveedor);
    }
}
