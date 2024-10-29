package ConversorDeMoedasApp;

import ConversorDeMoedasApi.APIService;
import ConversorDeMoedasConsole.ConversorDeMoedasConsole;

import java.util.Scanner;

public class ConversorMoedaApp {
    private ConversorDeMoedasConsole conversor;
    private APIService apiService;

    public ConversorMoedaApp() {
        this.apiService = new APIService();
        this.conversor = new ConversorDeMoedasConsole(apiService.obterTaxasCambio());
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        String[] currencyCodes = apiService.getCurrencyCodes();

        System.out.println("--- Conversor de Moedas ---");
        while (true) {
            System.out.println("Escolha a moeda de origem:");
            exibirOpcoesMoedas(currencyCodes);
            String moedaOrigem = currencyCodes[scanner.nextInt() - 1];

            System.out.println("Escolha a moeda de destino:");
            exibirOpcoesMoedas(currencyCodes);
            String moedaDestino = currencyCodes[scanner.nextInt() - 1];

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            double valorConvertido = conversor.converter(moedaOrigem, moedaDestino, valor);
            System.out.printf("%.2f %s é igual a %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);

            System.out.print("Deseja realizar outra conversão? (s/n): ");
            if (scanner.next().equalsIgnoreCase("n")) break;
        }
        scanner.close();
        System.out.println("Conversor encerrado.");
    }

    private void exibirOpcoesMoedas(String[] currencyCodes) {
        for (int i = 0; i < currencyCodes.length; i++) {
            System.out.println((i + 1) + ". " + currencyCodes[i]);
        }
    }

    public static void   main(String[] args) {
        ConversorMoedaApp app = new ConversorMoedaApp();
        app.iniciar();
    }
}

