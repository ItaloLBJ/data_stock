package usecase;

import products.Maquiagem;

import java.util.ArrayList;

public class MaquiagemUseCase {

    private static ArrayList<Maquiagem> listaMaquiagem = new ArrayList<>();

    static {
        listaMaquiagem.add(new Maquiagem(6, "Base Líquida", "Boticário", 20, 0.05, 45.9, "Base"));
        listaMaquiagem.add(new Maquiagem(7, "Batom Matte", "Eudora", 50, 0.02, 29.9, "Batom"));
        listaMaquiagem.add(new Maquiagem(8, "Máscara de Cílios", "Boticário", 30, 0.03, 39.9, "Máscara de Cílios"));
        listaMaquiagem.add(new Maquiagem(9, "Sombra Compacta", "Eudora", 40, 0.01, 22.5, "Sombra"));
        listaMaquiagem.add(new Maquiagem(10, "Delineador Líquido", "Boticário", 25, 0.02, 35.0, "Delineador"));
    }


    public static String adicionarMaquiagem(Maquiagem maquiagem) {
        if (maquiagemExiste(maquiagem.getCodigo())) {
            return "Maquiagem com este código já existe!";
        }
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
            if (listaMaquiagem.get(i).getCodigo() == codigo) {
                listaMaquiagem.remove(i);
                return true;
            }

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