package com.ptuppy.registryofficesapi.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(final ClientHttpConnector httpClient) {
        return WebClient.builder().clientConnector(httpClient).build();
    }

    @Bean
    public ClientHttpConnector createClient(final HttpClient httpClient) {
        return new ReactorClientHttpConnector(httpClient);
    }

    @Bean
    public HttpClient httpClient(@Value("${client.timeout.connect}") final Integer connectTimeOut, @Value("${client.timeout.read}") final Integer readTimeout) {
        return HttpClient.create().tcpConfiguration(tcpClient -> prepareTCPClient(connectTimeOut, readTimeout, tcpClient));
    }

    private TcpClient prepareTCPClient(final Integer connectTimeOut, final Integer readTimeout, TcpClient tcpClient) {
        tcpClient = tcpClient.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeOut);
        tcpClient = tcpClient.doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS)));

        return tcpClient;
    }

}
