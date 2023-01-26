/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ista.cristhianpallmay.web.app.Sevice;

import com.ista.cristhianpallmay.web.app.Entity.Productos;
import com.ista.cristhianpallmay.web.app.Repository.RepositoryProducto;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author educr
 */
@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private RepositoryProducto repositoryProducto;
    
    @Override
    @Transactional(readOnly = true)
    public Iterable<Productos> findAll() {
        return repositoryProducto.findAll();
    }

   @Override
   @Transactional(readOnly = true)
    public Page<Productos> findAll(Pageable pageable) {
        return repositoryProducto.findAll(pageable);
    }

    @Override
    public Optional<Productos> findById(Long id) {
        return repositoryProducto.findById(id);
    }

    @Override
    public Productos save(Productos producto) {
        return repositoryProducto.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        repositoryProducto.deleteById(id);
    }

    
    
}
