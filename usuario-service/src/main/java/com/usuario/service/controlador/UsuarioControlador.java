package com.usuario.service.controlador;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenTodos();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.getUsuarioPorID(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = usuarioService.getUsuarioPorID(usuarioId);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioService.getCarros(usuarioId));
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int usuarioId) {
        Usuario usuario = usuarioService.getUsuarioPorID(usuarioId);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioService.getMotos(usuarioId));
    }
}
