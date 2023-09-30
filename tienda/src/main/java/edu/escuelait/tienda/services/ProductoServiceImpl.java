package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Producto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Override
    public Optional<Producto> getProductoPorId(Long id) {
        if(id>0){
            Double va = 2.0;
        Producto ordenador = new Producto(1L,"Ordenador");
        return Optional.ofNullable(ordenador);
        }
        return Optional.empty();
    }
}
