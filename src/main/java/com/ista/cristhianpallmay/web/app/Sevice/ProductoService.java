/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ista.cristhianpallmay.web.app.Sevice;

import com.ista.cristhianpallmay.web.app.Entity.Productos;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 *
 * @author educr
 */
public interface ProductoService {
    
    public Iterable<Productos> findAll();
    
    public Page<Productos> findAll(Pageable pageable);
    
    public Optional<Productos> findById(Long id);
    
    public Productos save(Productos user);
    
    public void deleteById(Long id);
}
