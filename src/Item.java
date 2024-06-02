public class Item {
    private String nome;
    private Integer preco;
    private Integer importancia;

    public Item() {
    }

    public Item(String nome, Integer preco, Integer importancia) {
        this.nome = nome;
        this.preco = preco;
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Integer getImportancia() {
        return importancia;
    }

    public void setImportancia(Integer importancia) {
        this.importancia = importancia;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", importancia=" + importancia +
                '}';
    }
}
