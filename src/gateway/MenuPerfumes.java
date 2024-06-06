package gateway;
import products.Perfumes;
import usecase.PerfumesUseCase;

import java.util.Scanner;
public class MenuPerfumes {

    public void executar_perfumes() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    **********************************
                    *                                *
                    *        Menu de Perfumes        *
                    *                                *
                    **********************************
                    
                    Selecione a opção desejada
                    
                    1 - Adicionar um novo perfume
                    2 - Pesquisar um perfume
                    3 - Ver todos os perfumes em estoque
                    4 - Remover um perfume do estoque
                    5 - Alterar os dados de um perfume em estoque
                    6 - Sair
                    
                    **********************************
                    
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
                    Perfumes perfumes = lerPerfume(sc);
                    System.out.println(PerfumesUseCase.adicionarPerfume(perfumes));
                    break;

                case 2:
                    boolean perfumeEncontrado = false;
                    while (!perfumeEncontrado) {
                        System.out.println("Insira o código o Perfume ou digite 0 para cancelar: ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de busca cancelada.");
                            break;
                        }
                        if (PerfumesUseCase.perfumeExiste(codigo)) {
                            System.out.println(PerfumesUseCase.mostrarPerfume(codigo));
                            perfumeEncontrado = true;
                        } else {
                            System.out.println("Perfume fornecido não existe. Tente novamente");
                        }
                    }
                    break;

                case 3:
                    System.out.println(PerfumesUseCase.mostrarPerfumes());
                    break;

                case 4:
                    boolean perfumeRemovido = false;
                    while (!perfumeRemovido) {
                        System.out.println("Insira o código do perfume ou digite 0 para cancelar: ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de remoção cancelada.");
                            break;
                        }
                        if (PerfumesUseCase.perfumeExiste(codigo)) {
                            PerfumesUseCase.removerPerfume(codigo);
                            System.out.println("Perfume removido com sucesso!");
                            perfumeRemovido = true;
                        } else {
                            System.out.println("Produto fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    boolean perfumeEditado = false;
                    while (!perfumeEditado) {
                        System.out.println("Insira o código do perfume a ser alterado ou digite 0 para cancelar: ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de edição cancelada.");
                            break;
                        }
                        if (PerfumesUseCase.perfumeExiste(codigo)) {
                            Perfumes novoPerfume = lerPerfume(sc);
                            System.out.println(PerfumesUseCase.editarPerfume(codigo, novoPerfume));
                            perfumeEditado = true;
                        } else {
                            System.out.println("Perfume fornecido não existe. Tente novamente.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Menu Produtos");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static Perfumes lerPerfume(Scanner sc) {
        System.out.println("Insira o código do perfume: ");
        int codigo = lerInt(sc);
        System.out.println("Insira o nome do perfume: ");
        String nome = sc.nextLine();
        System.out.println("Insira a fragãncia do perfume: ");
        String fragancia = sc.nextLine();
        System.out.println("Insira a marca do perfume: ");
        String marca = sc.nextLine();
        System.out.println("Insira a quantidade do perfume: ");
        int quantidade = lerInt(sc);
        System.out.println("Insira o peso do perfume: ");
        double peso = lerDouble(sc);
        System.out.println("Insira o valor do perfume: ");
        double valor = lerDouble(sc);

        return new Perfumes(codigo, nome, marca, quantidade, peso, valor, fragancia);
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