import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Populacao {

    static Random random = new Random();

    /**
     *
     * Inicializa uma população inicial
     *
     * @param tamCromossomo - Indica o tamanho de cada cromossomo, equivale ao tamanho da lista de Items do problema
     * @param tamPopulacao - Indica o tamanho população que será gerada
     * @return - Lista com Cromossomos
     */
    public static List<Cromossomo> inicializar(int tamCromossomo, int tamPopulacao){
        List<Cromossomo> populacao = new ArrayList<>(tamPopulacao);
        for (int i = 0; i < tamPopulacao; i++){
            Cromossomo cromossomo = new Cromossomo(tamCromossomo);
            for (int j = 0; j < tamCromossomo; j++){
                cromossomo.getGenes().add(j, random.nextInt(2));
            }
            populacao.add(cromossomo);
        }
        return populacao;
    }

    /**
     *
     * Calcula e seta os valores fitness para cada cromossomo da nossa população
     *
     * @param populacao - Lista de cromossomos
     */
    public static void calcFitness(List<Cromossomo> populacao){
        for (Cromossomo cromossomo : populacao){ // Percorrendo cada Cromossomo da populacao
            int somaImportancia = 0;
            int somaCusto = 0;
            //Percorrendo os Genes do cromossomo, que são uma lista de vetores 0 ou 1, onde:
            // 1 - repesenta que aquele item está presente
            // 0 - reperesenta que aquele item não está presente
            for (int i = 1; i < cromossomo.getGenes().size(); i++){
                if (cromossomo.getGenes().get(i) == 1){ // Verifica se um item esta nesse cromossomo
                    somaImportancia += AlgoritmoGenetico.itens.get(i).getImportancia(); // soma a importancia
                    somaCusto += AlgoritmoGenetico.itens.get(i).getPreco();
                }
            }
            // Nesse momento, estou salvando até os valores onde o Custo é maior, para caso queira mudar mais a frente
            cromossomo.setFitness(somaImportancia);
            cromossomo.setCusto(somaCusto);
        }
    }

    /**
     *
     * Faz o sorteio por meio de uma "roleta" de dois cromossomos da nossa população que posteriormente passarão
     * pelo processo de Crossover. Com esse método buscamos ser proporcionais, ou seja, quanto maior o valor fitness
     * do cromossomo, mais chances ele tem de ser sorteado
     *
     * @param populacao - população atual
     * @return - Vetor com dois cromossomos selecionados
     */
    public static Cromossomo[] roleta(List<Cromossomo> populacao){
        Cromossomo[] pais = new Cromossomo[2]; // Instancia um vetor
        // soma todos os valores fitness de cada cromossomo da população
        int totalFitness = populacao.stream().mapToInt(c -> c.getFitness()).sum();

        for (int i = 0; i < 2; i++){
            int giro = random.nextInt(totalFitness); // Sorteia um valor
            int sum = 0; // Vai ser usada para percorrer os valores até a parte correspondente na "roleta"
            for (Cromossomo cromossomo : populacao){
                sum += cromossomo.getFitness(); // Vai adicionando os valores fitness
                if (sum >= giro){ // Indica que chegamos na porção sorteada da roleta
                    pais[i] = cromossomo; // Adiciona o cromossomo ao vetor que vai ser retornado
                    break;
                }
            }
        }
        return pais;
    }

}
