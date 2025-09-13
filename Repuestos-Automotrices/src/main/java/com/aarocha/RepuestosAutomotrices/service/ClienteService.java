package com.aarocha.RepuestosAutomotrices.service;

import com.aarocha.RepuestosAutomotrices.model.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Integer idCliente);
    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Integer idCliente, Cliente cliente);
    void deleteCliente(Integer idCliente);
}
