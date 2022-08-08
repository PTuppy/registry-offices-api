package com.ptuppy.registryofficesapi.service;

import com.ptuppy.registryofficesapi.configuration.WebConfig;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class BaseRemoteService {

    protected final WebClient webClient;

    protected final WebConfig webConfig;

    public BaseRemoteService(final WebClient webClient, final WebConfig webConfig) {
        this.webClient = webClient;
        this.webConfig = webConfig;
    }

/*    *//** Transform generic error (5xx) from the client into a understandable exception *//*
    protected Throwable handleServerError(final ClientResponse clientResponse) {
        return clientResponse
                .body()
                .doOnSuccess(errorResponse -> log.error("==== Ame returned server error -> [{}]. Body --> {}", clientResponse.statusCode(), errorResponse))
                .switchIfEmpty(Mono.error(ClientException::new))
                .flatMap(errorResponse -> Mono.error(new ClientException(errorResponse.getErrorDescription())));
    }

    *//** Transforms bad request error (400) from the client into a understandable exception *//*
    protected HttpClientErrorException.BadRequest handleBadRequest(final ClientResponse clientResponse) {
        return clientResponse
                .body(HttpClientErrorException.BadRequest.class)
                .switchIfEmpty(Mono.error(HttpClientErrorException.BadRequest::new))
                .flatMap(errorResponse -> Mono.error(new BadHttpRequest(errorResponse.getErrorDescription())));
    }

    *//** Transforms a not found error (404) from the client into a understandable exception *//*
    protected NotFoundException handleNotFound(final ClientResponse clientResponse) {
        return clientResponse
                .bodyToMono(DefaultExceptionSerializer.class)
                .doOnSuccess(errorResponse -> log.error("==== Ame returned a not found error -> [{}]. Body --> {}", clientResponse.statusCode(), errorResponse))
                .switchIfEmpty(Mono.error(NotFoundException::new))
                .flatMap(errorResponse -> Mono.error(new NotFoundException(errorResponse.getErrorDescription())));
    }*/

}
