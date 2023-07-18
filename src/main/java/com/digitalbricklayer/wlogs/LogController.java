package com.digitalbricklayer.wlogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/logs")
@RestController
public class LogController {


    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PutMapping
    void addNovaEntrada() throws Exception {
        logger.info("Estou na api de logs que adicionam logs a entrada");
        String usuarioCorrente = SecurityContextHolder.getContext().getAuthentication().getName();

        if (!usuarioCorrente.equals("vitor")) {
            logger.error("Deve finalizar a chamada com erro, usuário não tem permissão pra add log, usuario corrente " + usuarioCorrente);
            throw new Exception("usuário não tem permissão pra add log");
        }
        logger.info("nova entrada adicionada ao log feita pelo o usuário " + usuarioCorrente);
    }
}
