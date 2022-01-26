package com.sahikran.httputil;

import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface RestHandler {
    
    CompletableFuture<HttpClient> getHttpClient(boolean isSSLEnabled, Duration timeout);

    Function<HttpClient, CompletableFuture<HttpResponse<InputStream>>> invokeARestCall(String pageUrl);

}
