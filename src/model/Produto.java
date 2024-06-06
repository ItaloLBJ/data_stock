package model;

public class Produto {
    private int codigo;
    private String nome;
    private String marca;
    private int quantidade;
    private double peso;
    private double valor;

    private Produto() {}

    public  Produto(int codigo, String nome, String marca, int quantidade, double peso, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.peso = peso;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Nome: %s | Marca: %s | Quantidade: %d | Volume: %.2fml | Valor: R$ %.2f",
                getCodigo(), getNome(), getMarca(), getQuantidade(), getPeso(), getValor());
        }

}