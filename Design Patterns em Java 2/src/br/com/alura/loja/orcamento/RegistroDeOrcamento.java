package br.com.alura.loja.orcamento;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;
import br.com.alura.loja.http.JavaHttpClient;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(JavaHttpClient orcamento) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orçamento não finalizado");
        }
        String url = "http://api";
        Map<String, ? extends Number> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeDeItens", orcamento.getQuantidadeItens());
        http.post(url, (Map<String, Number>) dados);
    }
}
