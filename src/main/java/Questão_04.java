/**
 * @author Carlos Alberto Souza Nascimento
 * @since 02/09/2024
 *
 * 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
 * • SP – R$67.836,43
 * • RJ – R$36.678,66
 * • MG – R$29.229,88
 * • ES – R$27.165,48
 * • Outros – R$19.849,53
 * Escreva um programa na linguagem que desejar onde calcule o percentual
 * de representação que cada estado teve dentro do valor total mensal da distribuidora.
 */
import java.util.ArrayList;
public class Questão_04 {

    public static void main(String[] args) {

        double valorFaturamentoSP = 67836.43;
        double valorFaturamentoRJ = 36678.66;
        double valorFaturamentoMG = 29229.88;
        double valorFaturamentoES = 27165.48;
        double valorFaturamentoOutros = 19849.53;

        ArrayList<Double> faturamentos = new ArrayList<>();
        faturamentos.add(valorFaturamentoSP);
        faturamentos.add(valorFaturamentoRJ);
        faturamentos.add(valorFaturamentoMG);
        faturamentos.add(valorFaturamentoES);
        faturamentos.add(valorFaturamentoOutros);

        double somaFaturamento = faturamentos.stream()
                .mapToDouble(Double::doubleValue).sum();

        for(int i = 0; i < faturamentos.size(); i++){
            double percentual = (faturamentos.get(i)/somaFaturamento)*100;
            switch (i){
                case 0:
                    System.out.printf("\nRepresentação percentual de SP = %.2f", percentual);
                    break;
                case 1:
                    System.out.printf("\nRepresentação percentual de RJ = %.2f", percentual);
                    break;
                case 2:
                    System.out.printf("\nRepresentação percentual de MG = %.2f", percentual);
                    break;
                case 3:
                    System.out.printf("\nRepresentação percentual de ES = %.2f", percentual);
                    break;
                case 4:
                    System.out.printf("\nRepresentação percentual de Outros = %.2f", percentual);
                    break;
            }

        }
    }

}
