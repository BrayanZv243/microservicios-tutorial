
package com.usuario.service.modelos;


public class Moto {
    
    private String marca;
    private String modelo;

    public Moto() {
        super();
    }

    public Moto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Moto{" + "marca=" + marca + ", modelo=" + modelo + '}';
    }
    
    
}
