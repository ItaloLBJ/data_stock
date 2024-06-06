package usecase;

import products.Perfumes;

import java.util.ArrayList;

public class PerfumesUseCase {
    private static ArrayList<Perfumes> listaPerfumes = new ArrayList<>();

    static {
        listaPerfumes.add(new Perfumes(11, "Perfume Floral", "Boticário", 15, 0.3, 120.9, "Floral"));
        listaPerfumes.add(new Perfumes(12, "Perfume Amadeirado", "Eudora", 10, 0.25, 150.0, "Amadeirado"));
        listaPerfumes.add(new Perfumes(13, "Perfume Cítrico", "Boticário", 20, 0.28, 135.5, "Cítrico"));
        listaPerfumes.add(new Perfumes(14, "Perfume Oriental", "Eudora", 8, 0.32, 180.75, "Oriental"));
        listaPerfumes.add(new Perfumes(15, "Perfume Frutado", "Boticário", 12, 0.27, 140.4, "Frutado"));
    }

    public static String adicionarPerfume(Perfumes perfumes) {
        if (perfumeExiste(perfumes.getCodigo())) {
            return "Perfume com este código já existe!";
        }
        listaPerfumes.add(perfumes);
        return "Perfume adicionado com sucesso!";
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
            if (listaPerfumes.get(i).getCodigo() == codigo) {
                listaPerfumes.remove(i);
                return true;
            }

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