import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlgoritmoGenetico {
    static List<Item> itens = new ArrayList<>();
    static Integer orcamento = 75;
    static Integer numeroGerecoes = 100;
    static Integer tamanhoPopulacao = 40;
    static Double taxaMutacao = 0.01;
    static Random random = new Random();

    public static void addItems(){
        itens.add(0, new Item());
        itens.add(1, new Item("Arroz", 22, 10));
        itens.add(2, new Item("Açucar", 3, 5));
        itens.add(3, new Item("Óleo", 8, 6));
        itens.add(4, new Item("Feijão", 5, 10));
        itens.add(5, new Item("Macarrão", 5, 8));
        itens.add(6, new Item("Sardinha", 5, 7));
        itens.add(7, new Item("Carne", 32, 9));
        itens.add(8, new Item("Frango", 13, 9));
        itens.add(9, new Item("Queijo", 8, 5));
        itens.add(10, new Item("Presunto", 4, 5));
        itens.add(11, new Item("Pão", 6, 6));
        itens.add(12, new Item("Banana", 4, 7));
        itens.add(13, new Item("Laranja", 2, 7));
        itens.add(14, new Item("Abacate", 7, 2));
        itens.add(15, new Item("Sabão", 2, 9));
        itens.add(16, new Item("Limpador Multiuso", 4, 6));
        itens.add(17, new Item("Água Tônica", 7, 1));
        itens.add(18, new Item("Polpa de fruta", 6, 4));
        itens.add(19, new Item("Refrigerante", 8, 3));
        itens.add(20, new Item("Cerveja", 6, 2));
    }
}
