package com.guilherme.bffagendadortarefas.business;

import com.guilherme.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.guilherme.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.guilherme.bffagendadortarefas.infrastrucutre.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTORequest salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO usuarioDTO) {
        return client.login(usuarioDTO);
    }

    public UsuarioDTORequest buscarUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {

        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadosUsuario(dto, token);
    }

    public UsuarioDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {

        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public UsuarioDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {

        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public UsuarioDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTORequest cadastraTelefone(String token, TelefoneDTORequest dto) {
        return client.cadastraTelefone(dto, token);
    }
}

