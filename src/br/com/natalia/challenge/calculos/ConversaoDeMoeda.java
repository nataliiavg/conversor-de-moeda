package br.com.natalia.challenge.calculos;

import br.com.natalia.challenge.modelos.ConsultaExchangeRateAPI;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversaoDeMoeda {
    public static void converteMoeda(String moedaInicial, String moedaConvertida, Scanner leitura) throws IOException, InterruptedException {
        ConsultaExchangeRateAPI consultaExchangeRateAPI = new ConsultaExchangeRateAPI();
        double cambio = consultaExchangeRateAPI.pegaCotacao(moedaInicial, moedaConvertida);

        System.out.println("Digite o valor em " + moedaInicial + ": ");
        double valor = leitura.nextDouble();

        double calculoConversaoMoeda = valor * cambio;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String valorInicialFormatado = pegaMoeda(valor, moedaInicial);
        String valorFinalFormatado = pegaMoeda(calculoConversaoMoeda, moedaConvertida);

        System.out.println("Resultado da Conversão: ");
        System.out.println(valorInicialFormatado + " equivale a " + valorFinalFormatado);

    }

    private static String pegaMoeda(double valor, String moeda) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return switch (moeda) {
            case "BRL" -> "R$" + decimalFormat.format(valor);
            case "USD" -> "$" + decimalFormat.format(valor);
            case "ARS" -> "ARS" + decimalFormat.format(valor);
            case "EUR" -> "€" + decimalFormat.format(valor);
            default -> decimalFormat.format(valor) + " " + moeda;
        };
    }
}
