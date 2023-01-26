/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ista.cristhianpallmay.web.app.Repository;

import com.ista.cristhianpallmay.web.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author educr
 */
@Repository
public interface RepositoryProducto extends JpaRepository<Productos, Long>{
    
}
