package model;

public class Funcionarios {
    private int id;
    private String nome;
    private String cargo;

    public Funcionarios(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Override
    public String toString() {
        return String.format("Id do Funcionário: %s | Nome do Funcionário: %s | Cargo: %s", id, nome, cargo);
    }
}