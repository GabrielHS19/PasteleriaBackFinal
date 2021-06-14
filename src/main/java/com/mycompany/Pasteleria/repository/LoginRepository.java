/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pasteleria.repository;

import com.mycompany.Pasteleria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabhs
 */
public interface LoginRepository extends JpaRepository<Usuario, Long>{
    
}
