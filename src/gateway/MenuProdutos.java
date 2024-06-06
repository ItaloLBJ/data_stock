package gateway;

import model.Produto;
import usecase.ProdutoUseCase;
import java.util.Scanner;

public class MenuProdutos {
    public void executar() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ***********************************
                    *                                 *
                    *    Menu de Produtos Diversos    *
                    *                                 *
                    ***********************************
                    
                    Selecione a opção desejada
                    
                    1 - Adicionar um novo produto
                    2 - Pesquisar um produto
                    3 - Ver todos os produtos em estoque
                    4 - Remover um produto do estoque
                    5 - Alterar os dados de um produto em estoque
                    6 - Sair
                    
                    ***********************************
                    
                    Digite aqui: """);
            int opcao_2;
            try {
                opcao_2 = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número.");
                sc.nextLine();
                continue;
            }

            switch (opcao_2) {
                case 1:
                    Produto produto = lerProduto(sc);
                    System.out.println(ProdutoUseCase.adicionarProduto(produto));
                    break;

                case 2:
                    boolean produtoEncontrado = false;
                    while (!produtoEncontrado) {
                        System.out.println("Insira o código do produto (ou digite 0 para cancelar): ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de busca cancelada.");
                            break;
                        }
                        if (ProdutoUseCase.produtoExiste(codigo)) {
                            System.out.println(ProdutoUseCase.mostrarProduto(codigo));
                            produtoEncontrado = true;
                        } else {
                            System.out.println("Produto fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    System.out.println(ProdutoUseCase.mostrarProdutos());
                    break;

                case 4:
                    boolean produtoRemovido = false;
                    while (!produtoRemovido) {
                        System.out.println("Insira o código do produto (ou digite 0 para cancelar): ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de remoção cancelada.");
                            break;
                        }
                        if (ProdutoUseCase.produtoExiste(codigo)) {
                            ProdutoUseCase.apagarProduto(codigo);
                            System.out.println("Produto apagado com sucesso!");
                            produtoRemovido = true;
                        } else {
                            System.out.println("Produto fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    boolean produtoEditado = false;
                    while (!produtoEditado) {
                        System.out.println("Insira o código do produto a ser alterado (ou digite 0 para cancelar): ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de edição cancelada.");
                            break;
                        }
                        if (ProdutoUseCase.produtoExiste(codigo)) {
                            Produto novoProduto = lerProduto(sc);
                            System.out.println(ProdutoUseCase.editarProduto(codigo, novoProduto));
                            produtoEditado = true;
                        } else {
                            System.out.println("Produto fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static Produto lerProduto(Scanner sc) {
        System.out.println("Insira o código do produto: ");
        int codigo = lerInt(sc);
        System.out.println("Insira o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Insira a marca do produto: ");
        String marca = sc.nextLine();
        System.out.println("Insira a quantidade do produto: ");
        int quantidade = lerInt(sc);
        System.out.println("Insira o peso do produto: ");
        double peso = lerDouble(sc);
        System.out.println("Insira o valor do produto: ");
        double valor = lerDouble(sc);

        return new Produto(codigo, nome, marca, quantidade, peso, valor);
    }

    protected static int lerInt(Scanner sc) {
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.println("Código inválido! Digite um número inteiro.");
                sc.nextLine();
            }
        }
    }

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                double numero = sc.nextDouble();
                sc.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número decimal.");
                sc.nextLine();
            }
        }
    }
}