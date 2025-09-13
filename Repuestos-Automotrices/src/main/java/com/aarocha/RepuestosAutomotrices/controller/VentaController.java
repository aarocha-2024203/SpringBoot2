package com.aarocha.RepuestosAutomotrices.controller;

import com.aarocha.RepuestosAutomotrices.model.Venta;
import com.aarocha.RepuestosAutomotrices.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{idVenta}")
    public Venta getVentaById(@PathVariable Integer idVenta){
        return ventaService.getVentaById(idVenta);
    }

    @PostMapping
    public ResponseEntity<?> createVenta(@RequestBody Venta venta){
        if (venta.getFechaVenta() == null) {
            return ResponseEntity.badRequest().body("La fecha no puede estar vacía");
        }
        if (venta.getCliente() == null || venta.getRepuesto() == null) {
            return ResponseEntity.badRequest().body("Cliente o Repuesto no pueden ser nulos");
        }
        if (venta.getCantidad() == null || venta.getCantidad() <= 0) {
            return ResponseEntity.badRequest().body("Cantidad debe ser mayor que 0");
        }
        if (venta.getTotal() == null || venta.getTotal().compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.badRequest().body("Total debe ser mayor que 0");
        }
        Venta savedVenta = ventaService.saveVenta(venta);
        return ResponseEntity.ok(savedVenta);
    }

    @PutMapping("/{idVenta}")
    public Venta updateVenta(@PathVariable Integer idVenta, @RequestBody Venta venta){
        return ventaService.updateVenta(idVenta, venta);
    }

    @DeleteMapping("/{idVenta}")
    public void deleteVenta(@PathVariable Integer idVenta){
        ventaService.deleteVenta(idVenta);
    }
}


