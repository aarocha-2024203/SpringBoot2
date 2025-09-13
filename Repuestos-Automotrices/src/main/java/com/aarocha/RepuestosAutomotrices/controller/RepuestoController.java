package com.aarocha.RepuestosAutomotrices.controller;

import com.aarocha.RepuestosAutomotrices.model.Repuesto;
import com.aarocha.RepuestosAutomotrices.service.RepuestoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @GetMapping
    public List<Repuesto> getAllRepuestos() {
        return repuestoService.getAllRepuestos();
    }

    @GetMapping("/{id}")
    public Repuesto getRepuestoById(@PathVariable Integer id) {
        return repuestoService.getRepuestoById(id);
    }

    @PostMapping
    public ResponseEntity<?> createRepuesto(@RequestBody Repuesto repuesto) {
        if (repuesto.getNombreRepuesto() == null || repuesto.getNombreRepuesto().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo nombre está vacío");
        }
        if (repuesto.getMarca() == null || repuesto.getMarca().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo marca está vacío");
        }
        Repuesto saved = repuestoService.saveRepuesto(repuesto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public Repuesto updateRepuesto(@PathVariable Integer id, @RequestBody Repuesto repuesto) {
        return repuestoService.updateRepuesto(id, repuesto);
    }

    @DeleteMapping("/{id}")
    public void deleteRepuesto(@PathVariable Integer id) {
        repuestoService.deleteRepuesto(id);
    }
}
