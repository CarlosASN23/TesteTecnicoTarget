/**
 * @author Carlos Alberto Souza Nascimento
 * @since 01/09/2024
 *
 * 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora,
 *    faça um programa, na linguagem que desejar, que calcule e retorne:
 * • O menor valor de faturamento ocorrido em um dia do mês;
 * • O maior valor de faturamento ocorrido em um dia do mês;
 * • Número de dias no mês em que o valor de faturamento diário foi superior à média
 *   mensal.
 *
 *   IMPORTANTE:
 * a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
 * b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
 *    Estes dias devem ser ignorados no cálculo da média;
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
public class Questão_03 {

    public static void main(String[] args) {

        try{

            // Leitura dos dados contidos no arquivo JSON
            FileReader leitura = new FileReader("faturamento.json");
            JsonElement jsonElement = JsonParser.parseReader(leitura);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            ArrayList<Double> faturamentoDiario = new ArrayList<>();

            // Gerar filtro com o faturamento diario
            for(JsonElement element : jsonArray){
                JsonObject dia = element.getAsJsonObject();
                double valor = dia.get("valor").getAsDouble();
                if(valor > 0){
                    faturamentoDiario.add(valor);
                }
            }

            // Verificar o menor valor de faturamento do mês
            double menorValorFaturamento = faturamentoDiario.stream()
                    .min(Double::compare).orElse(0.0);
            // Verificar o maior valor de faturamento do mês
            double maiorValorFaturamento = faturamentoDiario.stream()
                    .max(Double::compare).orElse(0.0);

            // Calcular a soma do faturamento Mensal
            double somaMensalFaturamento = faturamentoDiario.stream()
                    .mapToDouble(Double::doubleValue).sum();
            // Calcular a média do faturamento menstal
            double mediaFaturamentoMensal = somaMensalFaturamento/faturamentoDiario.size();

            // Verificar os dias em que o faturamento foi maior que a media mensal
            long diasAcimaDaMedia = faturamentoDiario.stream()
                    .filter(valor -> valor > mediaFaturamentoMensal).count();

            System.out.printf("O menor valor de faturamento ocorrido no mês foi: %.2f"+
                              "\nO maior valor de faturamento ocorrido no mês foi: R$ %.2f" +
                              "\nMédia mensal= R$ %.2f" +
                              "\nO total de numero de dias em que o faturamento diario foi maior que a media mensal = %d"
                              ,menorValorFaturamento,maiorValorFaturamento,mediaFaturamentoMensal,diasAcimaDaMedia);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
