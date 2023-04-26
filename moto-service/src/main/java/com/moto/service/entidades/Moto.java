package com.moto.service.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int usuarioId;

    public Moto(){
        super();
    }

    public Moto(int id, String marca, String modelo, int usuarioId) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.usuarioId = usuarioId;
    }

    public Moto(int id) {
        this.id = id;
    }
}