package products;

import model.Produto;

public class Perfumes extends Produto {

    private String fragancia;

    public String getFrangancia() {
        return fragancia;
    }

    public void setFrangancia(String frangancia) {
        this.fragancia = frangancia;
    }

    public Perfumes(int codigo, String nome, String marca, int quantidade, double peso, double valor, String fragancia) {
        super(codigo, nome, marca, quantidade, peso, valor);
        this.fragancia = fragancia;
    }

    @Override
    public String toString(){
        return "| Código: " + getCodigo() +" - " +
                "Nome: " + getNome() + " - " +
                "Marca: " + getMarca() + " - " +
                "Quantidade: " + getQuantidade() + "ml - " +
                "Volume: " + getPeso() + "ml - " +
                "Valor: R$" + getValor() + " - " +
                "Fragrância: " + getFrangancia() + " |";
    }
}