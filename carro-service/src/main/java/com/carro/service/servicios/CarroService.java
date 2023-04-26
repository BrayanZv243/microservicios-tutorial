package com.carro.service.servicios;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.ICarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private ICarroRepositorio carroRepositorio;

    public List<Carro> obtenTodos() {
        return carroRepositorio.findAll();
    }

    public Carro getCarroPorID(int id) {
        return carroRepositorio.findById(id).orElse(null);
    }

    public Carro saveCarro(Carro carro) {
        return carroRepositorio.save(carro);
    }

    public List<Carro> byUsuarioId(int usuarioId) {
        return carroRepositorio.findByUsuarioId(usuarioId);
    }

}
