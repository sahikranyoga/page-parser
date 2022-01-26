package com.sahikran.httputil;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.net.ssl.SSLContext;

import com.sahikran.exception.RestHandlerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpsRestHandler implements RestHandler {

    private static final Logger log = LoggerFactory.getLogger(HttpsRestHandler.class);

    @Override
    public CompletableFuture<HttpClient> getHttpClient(boolean isSSLEnabled, Duration timeout) {
        return CompletableFuture.supplyAsync(() -> {
                log.info("creating http client in async thread " + Thread.currentThread().getName());
                return gHttpClient(isSSLEnabled, timeout);
            }
        );
    }

    protected HttpClient gHttpClient(boolean isSSLEnabled, Duration timeout){
        SSLContext sslContext = null;
        
                if(isSSLEnabled){
                    try {
                        sslContext = SSLContext.getInstance("TLSv1.3");
                        sslContext.init(null, null, null);
                    } catch (NoSuchAlgorithmException | KeyManagementException e) {
                        throw new RestHandlerException("unable to initialize ssl context ", e);
                    }
                }
                log.info("creating http client with SSL context " + Thread.currentThread().getName());
                return HttpClient.newBuilder()
                                .sslContext(sslContext)
                                .followRedirects(Redirect.NORMAL)
                                .connectTimeout(timeout)
                                .build();
    }

    @Override
    public Function<HttpClient, CompletableFuture<HttpResponse<InputStream>>> invokeARestCall(String pageUrl) {
        return httpClient -> {
            HttpRequest httpRequest;
            try {
                log.info("creating http request in async thread " + Thread.currentThread().getName());
                httpRequest = HttpRequest.newBuilder()
                                            .uri(new URI(pageUrl))
                                            .header("Accept-Encoding", "gzip")
                                            .GET()
                                            .build();
            } catch (URISyntaxException e) {
                throw new RestHandlerException("httprequest cant be initiliazed ", e);
            }
            log.info("calling target using http client send async " + pageUrl);
            return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
        };
    }
    
}
