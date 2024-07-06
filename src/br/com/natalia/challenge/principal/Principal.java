package br.com.natalia.challenge.principal;

import br.com.natalia.challenge.calculos.ConversaoDeMoeda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String moedaInicial = "";
        String moedaFinal = "";
        int opcao;

        do {
            System.out.println("=====================================");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda! \n");
            System.out.println("(1) Real Brasileiro (BRL) => Dólar (USD) ");
            System.out.println("(2) Dólar (USD) => Real Brasileiro (BRL) ");
            System.out.println("(3) Dólar (USD) => Peso Argentino (ARS) ");
            System.out.println("(4) Peso Argentino (ARS) => Dólar (USD) ");
            System.out.println("(5) Euro (EUR) => Dólar (USD) ");
            System.out.println("(6) Dólar (USD) => Euro (EUR) ");
            System.out.println("(7) Sair ");
            System.out.println("=====================================\n");

            System.out.println("Escolha uma das opções listadas acima: ");
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    ConversaoDeMoeda.converteMoeda("BRL", "USD", leitura);
                    break;
                case 2:
                    ConversaoDeMoeda.converteMoeda("USD", "BRL", leitura);
                    break;
                case 3:
                    ConversaoDeMoeda.converteMoeda("USD", "ARS", leitura);
                    break;
                case 4:
                    ConversaoDeMoeda.converteMoeda("ARS", "USD", leitura);
                    break;
                case 5:
                    ConversaoDeMoeda.converteMoeda("EUR", "USD", leitura);
                    break;
                case 6:
                    ConversaoDeMoeda.converteMoeda("USD", "EUR", leitura);
                    break;
                case 7:
                    System.out.println("Aplicativo encerrado.");
                    break;
                default:
                    System.out.println("=====================================");
                    System.out.println("Opção inválida!");
                    System.out.println("=====================================\n");
            }

            if (opcao != 7) {
                System.out.println("\n Aperte ENTER para continuar");
                leitura.nextLine();
                leitura.nextLine();
            }
        } while (opcao != 7);

        leitura.close();
        System.exit(0);
    }
}
