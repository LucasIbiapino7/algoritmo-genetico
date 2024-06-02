import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlgoritmoGenetico.addItems();
        System.out.println(AlgoritmoGenetico.itens.size());
        List<Cromossomo> populacao = Populacao.inicializar(AlgoritmoGenetico.itens.size(), AlgoritmoGenetico.tamanhoPopulacao);
        Populacao.calcFitness(populacao);
        for (Cromossomo c : populacao){
            System.out.println(c.getGenes() + " - Valor Fitness: " + c.getFitness() + " - Custo: " + c.getCusto());
        }
        int totalFitness = populacao.stream().mapToInt(c -> c.getFitness()).sum();
        System.out.println(totalFitness);
        System.out.println(AlgoritmoGenetico.random.nextInt(totalFitness));
    }

    /*
    int i = 0;
        for (Item item : AlgoritmoGenetico.itens){
            System.out.println("item " + i + " - " + item);
            i++;
        }
     */
}