/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pasteleria.controller;

import com.mycompany.Pasteleria.model.Pedido;
import com.mycompany.Pasteleria.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author jahaziel
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class PedidoController {

    @Autowired
    private PedidoRepository productoRepository;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> addPed(@RequestBody Pedido pedido) {
        try {
            Pedido empdo = productoRepository.save(pedido);
            return new ResponseEntity<>(empdo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Void> deleteEmpdoById(@PathVariable("id") Long id) {
        try {
            productoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pedido/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable("id") long id, @RequestBody Pedido pedido) {
        return productoRepository.findById(id).map(p -> {
            p.setNombre_cliente(pedido.getNombre_cliente());
            p.setNumero_telefono(pedido.getNumero_telefono());
            p.setTipo_pastel(pedido.getTipo_pastel());
            p.setDireccion_entrega(pedido.getDireccion_entrega());
            p.setEspecificacion(pedido.getEspecificacion());
            p.setPrecio_total(pedido.getPrecio_total());
            p.setFecha_entrega(pedido.getFecha_entrega());
            p.setCantidad(pedido.getCantidad());
            Pedido updated = productoRepository.save(p);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> getAllEmpdos() {
        try {
            List<Pedido> pedidos = productoRepository.findAll();
            if (pedidos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getEmpdoById(@PathVariable("id") Long id) {
        try {
            Pedido pedido = productoRepository.findById(id).get();
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
