package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    BigDecimal reajuste;
    public void recebeReajuste(Funcionario funcionario, Desempenho desempenho) {

        switch (desempenho) {
            case A_DESEJAR:
                reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
                break;
            case BOM:
                 reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
                break;
            case OTIMO:
                 reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
                break;
        }

        funcionario.reajusteSalario(reajuste);
    }
}
