package com.usuario.service.servicio;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class UsuarioService {

    private static final int PUERTO_CARROS = 8002;
    private static final int PUERTO_MOTOS = 8003;

    private static final String URI = "http://localhost:";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    public List<Usuario> obtenTodos() {
        return usuarioRepositorio.findAll();
    }

    public Usuario getUsuarioPorID(int id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public List<Carro> getCarros(int usuarioId) {
        return restTemplate.getForObject(URI + PUERTO_CARROS + "/carro/usuario/" + usuarioId, List.class);
    }

    public List<Moto> getMotos(int usuarioId) {
        return restTemplate.getForObject(URI + PUERTO_MOTOS + "/moto/usuario/" + usuarioId, List.class);
    }

}
