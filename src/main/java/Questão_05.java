/**
 * @author Carlos Alberto Souza Nascimento
 * @since 02/09/2024
 *
 * 5) Escreva um programa que inverta os caracteres de um string.
 *
 * IMPORTANTE:
 * a) Essa string pode ser informada através de qualquer entrada de sua
 *    preferência ou pode ser previamente definida no código;
 * b) Evite usar funções prontas, como, por exemplo, reverse;
 */

import java.util.Scanner;
public class Questão_05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Entrando com a palavra via terminal
        System.out.println("Digite uma palavara: ");
        String palavra = sc.nextLine();

        // Convertendo a palavra em um Array contendo os caracteres da palavra
        char[] letra = palavra.toCharArray();

        // Inicilização das variaveis que receberam as conversões
        String novaPalavra = "";
        String inversao = "";

        // Bloco condicional para realizar a conversão da palavra ao contrario
        for (int i = palavra.length(); i>0; i--){

            char letraContraria = letra[i-1];
            novaPalavra = Character.toString(letraContraria);
            inversao += novaPalavra;
        }

        // Impressão do resultado (palavra ao contrário)
        System.out.printf("O inverso da Palavra informada é: %s",inversao);
    }
}
