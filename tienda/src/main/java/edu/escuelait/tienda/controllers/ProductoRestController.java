package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.exception.ProductoNoFoundException;
import edu.escuelait.tienda.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    ProductoService productoService;

    public ProductoRestController(ProductoService productoService) {
        this.productoService=productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoPorId(@PathVariable Long id){


     //   return this.productoService.getProductoPorId(id).map(producto ->
        //{return ResponseEntity.ok(producto);
         //}).orElseThrow(ProductoNoFoundException::new);


 //       Forma basica de hacerlo
        Optional<Producto> optionalProducto = this.productoService.getProductoPorId(id);

       if(optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            return ResponseEntity.ok(producto);
        }

        throw  new ProductoNoFoundException();
       // return ResponseEntity.notFound().build();
    }


}
