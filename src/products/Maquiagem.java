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
        return String.format("Código: %d | Nome: %s | Marca: %s | Quantidade: %d | Peso: %.2fg(ml) | Valor: R$ %.2f | Tipo: %s",
                getCodigo(), getNome(), getMarca(), getQuantidade(), getPeso(), getValor(), getTipo());
    }
}