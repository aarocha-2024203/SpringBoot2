package com.aarocha.RepuestosAutomotrices.controller;
import com.aarocha.RepuestosAutomotrices.model.Cliente;
import com.aarocha.RepuestosAutomotrices.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/{idCliente}")
    public Cliente getClienteById(@PathVariable Integer idCliente){
        return clienteService.getClienteById(idCliente);
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente){
        if (cliente.getNombreCliente() == null || cliente.getNombreCliente().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo nombreCliente está vacío");
        }
        Cliente savedCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(savedCliente);
    }

    @PutMapping("/{idCliente}")
    public Cliente updateCliente(@PathVariable Integer idCliente, @RequestBody Cliente cliente){
        return clienteService.updateCliente(idCliente, cliente);
    }

    @DeleteMapping("/{idCliente}")
    public void deleteCliente(@PathVariable Integer idCliente){
        clienteService.deleteCliente(idCliente);
    }
}
