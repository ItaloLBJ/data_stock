package usecase;

import model.Produto;

import java.util.ArrayList;

public class ProdutoUseCase {

    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public static String adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        return "Produto adicionado com sucesso!";
    }

    public static String mostrarProdutos() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : listaProdutos){
            sb.append(produto.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Produto mostrarProduto(int codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) return produto;
        }
        return null;
    }

    public static boolean apagarProduto(int codigo) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getCodigo() == codigo) listaProdutos.remove(i);
            return true;
        }
        return false;
    }

    public static Produto editarProduto(int codigo, Produto novoProduto) {
        apagarProduto(codigo);
        adicionarProduto(novoProduto);
        return novoProduto;
    }

    public static boolean produtoExiste(int codigo) {
        return listaProdutos.stream().anyMatch(produto -> produto.getCodigo() == codigo);
    }
}