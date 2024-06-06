package products;

import model.Produto;

public class Perfumes extends Produto {

    private String fragrancia;

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    public Perfumes(int codigo, String nome, String marca, int quantidade, double peso, double valor, String fragrancia) {
        super(codigo, nome, marca, quantidade, peso, valor);
        this.fragrancia = fragrancia;
    }

    @Override
    public String toString(){
        return String.format("Código: %d | Nome: %s | Marca: %s | Quantidade: %d | Volume: %.2fml | Valor: R$ %.2f | Fragrância: %s",
                getCodigo(), getNome(), getMarca(), getQuantidade(), getPeso(), getValor(), getFragrancia());


    }
}