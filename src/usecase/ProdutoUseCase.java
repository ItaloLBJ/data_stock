package usecase;

import model.Produto;

import java.util.ArrayList;

public class ProdutoUseCase {

    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    static {
        listaProdutos.add(new Produto(1, "Creme Hidratante", "Boticário", 50, 0.3, 25.5));
        listaProdutos.add(new Produto(2, "Shampoo Nutritivo", "Eudora", 30, 0.5, 18.9));
        listaProdutos.add(new Produto(3, "Condicionador Nutritivo", "Eudora", 30, 0.5, 20.9));
        listaProdutos.add(new Produto(4, "Sabonete Líquido", "Boticário", 100, 0.2, 12.0));
        listaProdutos.add(new Produto(5, "Loção Corporal", "Eudora", 40, 0.4, 30.0));
    }

    public static String adicionarProduto(Produto produto) {
        if (produtoExiste(produto.getCodigo())) {
            return "Produto com este código já existe!";
        }
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
            if (listaProdutos.get(i).getCodigo() == codigo){
                listaProdutos.remove(i);
                return true;
            }

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