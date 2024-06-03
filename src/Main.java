import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlgoritmoGenetico.addItems();
        System.out.println(AlgoritmoGenetico.itens.size());
        List<Cromossomo> populacao = Populacao.inicializar(AlgoritmoGenetico.itens.size(), AlgoritmoGenetico.tamanhoPopulacao);

        for (int i = 0; i < AlgoritmoGenetico.numeroGerecoes; i++){
            Populacao.calcFitness(populacao);
            for (Cromossomo c : populacao){
                System.out.println(c.genesToString() + " - Valor Fitness: " + c.getFitness() + " - Custo: " + c.getCusto());
            }
            populacao = Populacao.evolui(populacao);
            System.out.println("============================================");
        }

        Cromossomo result = Populacao.resultado(populacao);
        System.out.println("Resultado Obtido: " + result);

    }

    /*
    int i = 0;
        for (Item item : AlgoritmoGenetico.itens){
            System.out.println("item " + i + " - " + item);
            i++;
        }
     */
}