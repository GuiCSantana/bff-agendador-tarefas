package com.guilherme.bffagendadortarefas.infrastrucutre.client;


import com.guilherme.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.guilherme.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.guilherme.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.guilherme.bffagendadortarefas.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTORequest buscarUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTORequest salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);

    @DeleteMapping("/{email}")
    Void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    UsuarioDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    UsuarioDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestParam("id") Long id,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    UsuarioDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                        @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTORequest cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                        @RequestHeader("Authorization") String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);
}