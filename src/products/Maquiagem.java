package products;

import model.Produto;

public class Maquiagem extends Produto {

    private String tipo;

    public String getTipo() {return tipo; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Maquiagem(int codigo, String nome, String marca, int quantidade, double peso, double valor, String tipo) {
        super(codigo, nome, marca, quantidade, peso, valor);
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "| Código: " + getCodigo() +" - " +
                "Nome: " + getNome() + " - " +
                "Marca: " + getMarca() + " - " +
                "Quantidade: " + getQuantidade() + " - " +
                "Peso: " + getPeso() + "g(ml) - " +
                "Valor: R$" + getValor() + " - " +
                "Tipo: " + getTipo() + " |";
    }
}