package com.lexvertex.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Servidor centralizado de configuración externa (Spring Cloud Config Server) del ecosistema.
 *
 * @author andres.restrepo@alternova.com
 * @version 1.0.0
 * @since 2026-04-20
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    /**
     * Punto de entrada principal para iniciar el servidor de configuración.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(final String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
