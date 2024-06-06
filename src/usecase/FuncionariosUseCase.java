package usecase;

import model.Funcionarios;

import java.util.ArrayList;

public class FuncionariosUseCase {

    private static ArrayList<Funcionarios> listaFuncionarios = new ArrayList<>();

    public static String adicionarFuncionario(Funcionarios funcionario) {
        listaFuncionarios.add(funcionario);
        return "Funcionário adicionado com sucesso!";
    }

    public static String mostrarFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (Funcionarios funcionarios : listaFuncionarios){
            sb.append(funcionarios.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Funcionarios pesquisarFuncionario(int id) {
        for (Funcionarios funcionarios : listaFuncionarios) {
            if (funcionarios.getId() == id) return funcionarios;
        }
        return null;
    }

    public static Funcionarios acharFuncionario(int id) {
        for (Funcionarios funcionario : listaFuncionarios) {
            if (funcionario.getId() == id) return funcionario;
        }
        return null;
    }

    public static boolean dispensarFuncionario(int id) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getId() == id) listaFuncionarios.remove(i);
            return true;
        }
        return false;
    }

    public static Funcionarios editarFuncionario(int id, Funcionarios  novoFuncionario) {
        dispensarFuncionario(id);
        adicionarFuncionario(novoFuncionario);
        return novoFuncionario;
    }
    public static boolean funcionarioExiste(int id) {
        return listaFuncionarios.stream().anyMatch(funcionarios -> funcionarios.getId() == id);
    }
}