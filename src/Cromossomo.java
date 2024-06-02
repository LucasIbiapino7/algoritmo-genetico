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
}
