package com.guilherme.bffagendadortarefas.business;

import com.guilherme.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.guilherme.bffagendadortarefas.infrastrucutre.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}