/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ista.cristhianpallmay.web.app.Controller;

import com.ista.cristhianpallmay.web.app.Entity.Productos;
import com.ista.cristhianpallmay.web.app.Sevice.ProductoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author educr
 */
@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoService productoS;

    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos user) {
        if (user.getCantidad() <= 0 || user.getPrecio()<= 0) {
            System.out.println("no se acepta valores menores a cero");
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(productoS.save(user));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long user_Id) {
        Optional<Productos> oProd = productoS.findById(user_Id);

        if (!oProd.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oProd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Productos ProdDetails, @PathVariable("id") Long idPro) {
        Optional<Productos> produc = productoS.findById(idPro);

        if (!produc.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        //BeanUtils.copyProperties(userDetails, user.get());
        produc.get().setDescripcion(ProdDetails.getDescripcion());
        produc.get().setCantidad(ProdDetails.getCantidad());
        produc.get().setPrecio(ProdDetails.getPrecio());

        return ResponseEntity.status(HttpStatus.CREATED).body(productoS.save(produc.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id_e) {
        if (!productoS.findById(id_e).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        productoS.deleteById(id_e);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Productos> readAll() {
        List<Productos> product = StreamSupport
                .stream(productoS.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return product;
    }
}
