package com.carro.service.repositorio;

import com.carro.service.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarroRepositorio extends JpaRepository<Carro,Integer> {

    List<Carro> findByUsuarioId(int usuarioId);

}
