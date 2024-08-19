package com.example.promethiumdataconnector.config;

import io.trino.client.ClientSession;
import io.trino.client.StatementClient;
import io.trino.client.StatementClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
public class TrinoConfig {

    @Value("${trino.host}")
    private String trinoHost;

    @Value("${trino.port}")
    private int trinoPort;

    @Value("${trino.user}")
    private String trinoUser;

    @Value("${trino.catalog}")
    private String trinoCatalog;

    @Value("${trino.schema}")
    private String trinoSchema;

    @Bean
    public ClientSession trinoClientSession() {
        URI serverURI = URI.create(String.format("http://%s:%d", trinoHost, trinoPort));
        return new ClientSession(
                serverURI,
                trinoUser,
                Optional.empty(),
                Optional.empty(),
                trinoCatalog,
                trinoSchema,
                new HashMap<>(),
                false,
                Optional.empty(),
                new HashMap<>(),
                "",
                Optional.empty()
        );
    }

    @Bean
    public StatementClient trinoStatementClient(ClientSession clientSession) {
        String query = "SELECT 1";
        return StatementClientFactory.newStatementClient(clientSession, query);
    }
}
