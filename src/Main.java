import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlgoritmoGenetico.addItems();
        System.out.println(AlgoritmoGenetico.itens.size());
        List<Cromossomo> populacao = Populacao.inicializar(AlgoritmoGenetico.itens.size(), AlgoritmoGenetico.tamanhoPopulacao);

        for (int i = 0; i < 2; i++){
            Populacao.calcFitness(populacao);
            for (Cromossomo c : populacao){
                System.out.println(c.getGenes() + " - Valor Fitness: " + c.getFitness() + " - Custo: " + c.getCusto());
            }
            System.out.println(populacao.size() + " - TAMANHO AQUI");
            populacao = Populacao.evolui(populacao);
            System.out.println("============================================");
        }

    }

    /*
    int i = 0;
        for (Item item : AlgoritmoGenetico.itens){
            System.out.println("item " + i + " - " + item);
            i++;
        }
     */
}