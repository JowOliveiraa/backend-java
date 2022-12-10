package br.com.alura.loja.http;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter{
    @Override
    public void post(String url, Map<String, Number> dados) {
        try {
            URL urlDaApi = new URL(url);
            URLConnection connection = urlDaApi.openConnection();
        } catch (Exception exception) {
            throw new RuntimeException("Erro ao enviar requisição HTTP");
        }
    }
}
