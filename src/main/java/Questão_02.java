/**
 * @author: Carlos Alberto Souza Nascimento
 * @since: 02/09/2024
 * 2)   Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e
 *      o próximo valor sempre será a soma dos 2 valores anteriores
 *      (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa
 *      na linguagem que desejar onde, informado um número, ele calcule a
 *      sequência de Fibonacci e retorne uma mensagem avisando se o número
 *      informado pertence ou não a sequência.
 *
 * @param:numero - Variavel a ser declarada pelo usuario (corresponde ao numero para se
 *         calcular a sequência Fibonnaci.
 *
 * @param:msg - Corresponde a variavel que receberá a mensagem que indicará se o número
 *              informado pelo usuário pertence ou não a sequência Fibonnaci
 *
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Questão_02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inicialização da variavel numero pssada pelo usuario
        System.out.println("Entre com um número inteiro para verificar a seguência Fibonnaci:  ");
        int numero = sc.nextInt();

        ArrayList<Integer> fibonnaci = new ArrayList<>();
        fibonnaci.add(0);
        fibonnaci.add(1);

        // Bloco para gerar a sequência Fibonnaci a partir no número informado
        for (int i = 1; i <= numero; i++) {

            int valorSequencia = fibonnaci.get(i) + fibonnaci.get(i - 1);
            fibonnaci.add(valorSequencia);
        }

        // Saida da sequência Fibonnaci
        System.out.println(fibonnaci);

        // Inicializador para a mensagem de saida (Verificação se pertence ou não a sequencia Fibonnaci)
        String msg = "";

        // Bloco para verificar se a variavel numero pertence a sequência Fibonnaci
        for (int k = 0; k < fibonnaci.size(); k++) {

            if (fibonnaci.get(k).equals(numero)) {
                msg = "O número informado pertence a sequência Fibonnaci!";
                break;
            }else{
                msg ="O número informado não pertence a sequência Fibonnaci!";
            }
        }

        System.out.println(msg);
    }
}
