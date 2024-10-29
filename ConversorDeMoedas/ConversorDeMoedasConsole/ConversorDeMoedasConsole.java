package ConversorDeMoedasConsole;

import java.util.Map;

//*************** Classe responsável pela lógica de conversão ****************************
public class ConversorDeMoedasConsole {
    private Map<String, Double> taxasCambio;


    public ConversorDeMoedasConsole(Map<String, Double> taxasCambio) {
        this.taxasCambio = taxasCambio;
    }

    public double converter(String moedaOrigem, String moedaDestino, double valor) {
        double taxaOrigem = taxasCambio.getOrDefault(moedaOrigem, 1.0);
        double taxaDestino = taxasCambio.getOrDefault(moedaDestino, 1.0);
        return valor * (taxaDestino / taxaOrigem);

    }

}