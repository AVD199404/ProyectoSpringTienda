package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Producto;

import java.util.Optional;

public interface ProductoService {
    public Optional<Producto> getProductoPorId(Long id);
}
