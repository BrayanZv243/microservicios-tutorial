package com.carro.service.controlador;

import com.carro.service.entidades.Carro;
import com.carro.service.servicios.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroControlador {

    @Autowired
    private CarroService carroService;


    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.obtenTodos();
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Carro> obtenerCarros(@PathVariable("id") int id){
        Carro carro = carroService.getCarroPorID(id);
        if(carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
        return ResponseEntity.ok(carroService.saveCarro(carro));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
        List<Carro> carros = carroService.byUsuarioId(usuarioId);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
