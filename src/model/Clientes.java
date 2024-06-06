package model;

public class Clientes {

    private String nome;
    private int numeroPedido;
    private String endereco;

    public Clientes(int numeroPedido, String nome, String endereco) {
        this.numeroPedido = numeroPedido;
        this.nome = nome;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() { return numeroPedido + "-" + nome + "-" + endereco;}
}