package usecase;

import products.Perfumes;

import java.util.ArrayList;

public class PerfumesUseCase {
    private static ArrayList<Perfumes> listaPerfumes = new ArrayList<>();

    public static String adicionarPerfume(Perfumes perfume) {
        listaPerfumes.add(perfume);
        return "Perfume adicionado com sucesso! ";
    }

    public static String mostrarPerfumes() {
        StringBuilder sb = new StringBuilder();
        for (Perfumes perfume : listaPerfumes){
            sb.append(perfume.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Perfumes mostrarPerfume(int codigo) {
        for (Perfumes perfume : listaPerfumes) {
            if (perfume.getCodigo() == codigo)
                return perfume;
        }
        return null;
    }

    public static Perfumes pesquisarPerfumes(int codigo) {
        for (Perfumes perfumes : listaPerfumes) {
            if (perfumes.getCodigo() == codigo) return perfumes;
        }
        return null;
    }

    public static boolean removerPerfume(int codigo) {
        for (int i = 0; i < listaPerfumes.size(); i++) {
            if (listaPerfumes.get(i).getCodigo() == codigo) listaPerfumes.remove(i);
            return true;
        }
        return false;
    }
    public static Perfumes editarPerfume(int codigo, Perfumes novoPerfume) {
        removerPerfume(codigo);
        adicionarPerfume(novoPerfume);
        return novoPerfume;
    }

    public static boolean perfumeExiste(int codigo) {
        return listaPerfumes.stream().anyMatch(perfumes -> perfumes.getCodigo() == codigo);
    }
}