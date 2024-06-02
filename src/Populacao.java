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

    public static List<Cromossomo> evolui(List<Cromossomo> populacao){
        List<Cromossomo> novaPopulacao = new ArrayList<>(populacao);
        for (int i = 0; i < 10; i++){
            Cromossomo[] pais = roleta(populacao);
            Cromossomo[] filhos = crossover(pais[0], pais[1]);
            novaPopulacao.add(filhos[0]);
            novaPopulacao.add(filhos[1]);
        }
        return novaPopulacao;
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
    private static Cromossomo[] roleta(List<Cromossomo> populacao){
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

    private static Cromossomo[] crossover(Cromossomo pai1, Cromossomo pai2){

        //System.out.println("PAI 1 - " + pai1.getGenes());
        //System.out.println("PAI 2 - " + pai2.getGenes());;

        Cromossomo filho1 = new Cromossomo(pai1.getGenes().size()); // Cria o primeiro filho
        Cromossomo filho2 = new Cromossomo(pai2.getGenes().size()); // Cria o segundo filho
        int pontoCrossover = random.nextInt(1, pai1.getGenes().size()); // Escolhe um ponto no vetor

        //System.out.println(pontoCrossover + " PONTO DO CORTE AQUI");

        for (int i = 0; i < pai1.getGenes().size(); i++){
            if (i < pontoCrossover){
                filho1.getGenes().add(i, pai1.getGenes().get(i)); // Adicciona no filho 1 os genes do pai 1
                filho2.getGenes().add(i, pai2.getGenes().get(i)); // Adiciona no filho 2 os genes do pai 2
            } else {
                filho1.getGenes().add(i, pai2.getGenes().get(i)); // Adicciona no filho 1 os genes do pai 2
                filho2.getGenes().add(i, pai1.getGenes().get(i)); // Adiciona no filho 2 os genes do pai 1
            }
        }

        //System.out.println("FILHO 1 - " + filho1.getGenes());
        //System.out.println("FILHO 2 - " + filho2.getGenes());
        return new Cromossomo[]{filho1, filho2}; // Retorna um vetor com os dois novos filhos
    }

}
