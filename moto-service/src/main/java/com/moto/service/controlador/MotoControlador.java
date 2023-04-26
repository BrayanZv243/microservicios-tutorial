package com.moto.service.controlador;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moto")
public class MotoControlador {

    @Autowired
    private MotoServicios motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos() {
        List<Moto> motos = motoService.obtenTodos();
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMotos(@PathVariable("id") int id) {
        Moto moto = motoService.getMotoPorID(id);
        if (moto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
        return ResponseEntity.ok(motoService.saveMoto(moto));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id) {
        List<Moto> motos = motoService.byUsuarioId(id);
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

}
