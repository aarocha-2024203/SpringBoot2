package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Cliente;
import com.aarocha.RepuestosAutomotrices.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Integer idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Integer idCliente, Cliente cliente) {
        Cliente existente = clienteRepository.findById(idCliente).orElse(null);
        if (existente != null) {
            existente.setNombreCliente(cliente.getNombreCliente());
            existente.setTelefono(cliente.getTelefono());
            existente.setDireccion(cliente.getDireccion());
            return clienteRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deleteCliente(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
