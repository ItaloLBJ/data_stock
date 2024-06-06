package usecase;

import products.Maquiagem;

import java.util.ArrayList;

public class MaquiagemUseCase {

    private static ArrayList<Maquiagem> listaMaquiagem = new ArrayList<>();

    public static String adicionarMaquiagem(Maquiagem maquiagem) {
        listaMaquiagem.add(maquiagem);
        return "Maquiagem adicionada com sucesso!";
    }

    public static String mostrarMaquiagens() {
        StringBuilder sb = new StringBuilder();
        for (Maquiagem maquiagem : listaMaquiagem){
            sb.append(maquiagem.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Maquiagem mostrarMaquiagem(int codigo) {
        for (Maquiagem maquiagem : listaMaquiagem) {
            if (maquiagem.getCodigo() == codigo) return maquiagem;
        }
        return null;
    }

    public static Maquiagem pesquisarMaquiagem(int codigo) {
        for (Maquiagem maquiagem : listaMaquiagem) {
            if (maquiagem.getCodigo() == codigo) return maquiagem;
        }
        return null;
    }

    public static boolean removerMaquiagem(int codigo) {
        for (int i = 0; i < listaMaquiagem.size(); i++){
            if (listaMaquiagem.get(i).getCodigo() == codigo) listaMaquiagem.remove(i);
            return true;
        }
        return false;
    }

    public static Maquiagem editarMaquiagem(int codigo, Maquiagem novaMaquiagem) {
        removerMaquiagem(codigo);
        adicionarMaquiagem(novaMaquiagem);
        return novaMaquiagem;
    }

    public static boolean maquiagemExiste(int codigo) {
        return listaMaquiagem.stream().anyMatch(maquiagem -> maquiagem.getCodigo() == codigo);
    }
}