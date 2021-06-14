/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Pasteleria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author jahaziel
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    
    @Column(name = "numero_telefono")
    private String numero_telefono;
    
    @Column(name = "direccion_entrega")
    private String direccion_entrega;
    
    @Column(name = "tipo_pastel")
    private String tipo_pastel;
    
    @Column(name = "especificacion")
    private String especificacion;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "fecha_entrega")
    private String fecha_entrega;
    
    @Column(name = "precio_total")
    private String precio_total;
    
    

    public Pedido() {
        
    }

    public Pedido(Long id, String nombre_cliente, String numero_telefono, String direccion_entrega, String tipo_pastel, String especificacion, String fecha_entrega, String precio_total,int cantidad) {
        this.id = id;
        this.nombre_cliente = nombre_cliente;
        this.numero_telefono = numero_telefono;
        this.direccion_entrega = direccion_entrega;
        this.tipo_pastel = tipo_pastel;
        this.especificacion = especificacion;
        this.fecha_entrega = fecha_entrega;
        this.precio_total = precio_total;
        this.cantidad = cantidad;
        
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getTipo_pastel() {
        return tipo_pastel;
    }

    public void setTipo_pastel(String tipo_pastel) {
        this.tipo_pastel = tipo_pastel;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
