import java.util.ArrayList;
import java.util.List;

public class Cromossomo implements Comparable<Cromossomo> {
    private List<Integer> genes;
    private Integer fitness;
    private Integer custo;

    public Cromossomo(int tam) {
        this.genes = new ArrayList<>(tam);
    }

    public List<Integer> getGenes() {
        return genes;
    }

    public void setGenes(List<Integer> genes) {
        this.genes = genes;
    }

    public Integer getFitness() {
        return fitness;
    }

    public void setFitness(Integer fitness) {
        this.fitness = fitness;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    @Override
    public int compareTo(Cromossomo o) {
        return - this.fitness.compareTo(o.fitness);
    }

    public String genesToString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 1; i < genes.size() - 1; i++){
            sb.append(genes.get(i)).append(", ");
        }
        sb.append(genes.getLast()).append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(genesToString());
        sb.append("\nValor Fitness: ").append(fitness);
        sb.append("\nCusto: ").append(custo);
        sb.append("\nItens: ");
        for (int i = 1; i < genes.size(); i++){
            if (genes.get(i) == 1){
                sb.append(i).append(" - ").append(AlgoritmoGenetico.itens.get(i)).append(" \n");
            }
        }
        return sb.toString();
    }
}
