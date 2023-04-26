package com.moto.service.servicios;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.IMotoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoServicios {

    @Autowired
    private IMotoRepositorio motoRepositorio;

    public List<Moto> obtenTodos() {
        return motoRepositorio.findAll();
    }

    public Moto getMotoPorID(int id) {
        return motoRepositorio.findById(id).orElse(null);
    }

    public Moto saveMoto(Moto moto) {
        return motoRepositorio.save(moto);
    }

    public List<Moto> byUsuarioId(int usuarioId) {
        return motoRepositorio.findByUsuarioId(usuarioId);
    }
}
